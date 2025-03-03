package com.mycompany.courseerpbackend.services.security;

import com.mycompany.courseerpbackend.exception.BaseException;
import com.mycompany.courseerpbackend.models.common.proceedkey.ProceedKey;
import com.mycompany.courseerpbackend.models.dto.RefreshTokenDto;
import com.mycompany.courseerpbackend.models.dto.SendOTPDto;
import com.mycompany.courseerpbackend.models.enums.branch.BranchStatus;
import com.mycompany.courseerpbackend.models.enums.user.UserStatus;
import com.mycompany.courseerpbackend.models.mappers.CourseEntityMapper;
import com.mycompany.courseerpbackend.models.mappers.UserEntityMapper;
import com.mycompany.courseerpbackend.models.mybatis.branch.Branch;
import com.mycompany.courseerpbackend.models.mybatis.course.Course;
import com.mycompany.courseerpbackend.models.mybatis.employee.Employee;
import com.mycompany.courseerpbackend.models.mybatis.role.Role;
import com.mycompany.courseerpbackend.models.mybatis.user.User;
import com.mycompany.courseerpbackend.models.payload.auth.LoginPayload;
import com.mycompany.courseerpbackend.models.payload.auth.RefreshTokenPayload;
import com.mycompany.courseerpbackend.models.payload.auth.signup.SignUpPayload;
import com.mycompany.courseerpbackend.models.payload.auth.signup.SignUpOTPChannelRequest;
import com.mycompany.courseerpbackend.models.payload.auth.signup.SignUpOTPRequest;
import com.mycompany.courseerpbackend.models.reponse.auth.LoginResponse;
import com.mycompany.courseerpbackend.services.branch.BranchService;
import com.mycompany.courseerpbackend.services.course.CourseService;
import com.mycompany.courseerpbackend.services.employee.EmployeeService;
import com.mycompany.courseerpbackend.services.otp.OTPFactory;
import com.mycompany.courseerpbackend.services.otp.OTPProceedTokenManager;
import com.mycompany.courseerpbackend.services.redis.RedisService;
import com.mycompany.courseerpbackend.services.role.RoleService;
import com.mycompany.courseerpbackend.services.user.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.mycompany.courseerpbackend.models.enums.response.ErrorResponseMessages.EMAIL_ALREADY_REGISTERED;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthBusinessServiceImpl implements AuthBusinessService {

    final static String COURSE_BRANCH_DEFAULT_PATTERN = "%s Default Branch";

    final AuthenticationManager authenticationManager;
    final AccessTokenManager accessTokenManager;
    final RefreshTokenManager refreshTokenManager;
    final UserService userService;
    final UserDetailsService userDetailsService;
    final BCryptPasswordEncoder passwordEncoder;
    final RoleService roleService;
    final CourseService courseService;
    final BranchService branchService;
    final EmployeeService employeeService;
    final OTPProceedTokenManager otpProceedTokenManager;
    final RedisService redisService;

    @Override
    public LoginResponse login(LoginPayload payload) {
        authenticate(payload);
        return prepareLoginResponse(payload.getEmail(), payload.isRememberMe());
    }

    @Override
    public LoginResponse refresh(RefreshTokenPayload payload) {
        return prepareLoginResponse(
                refreshTokenManager.getEmail(payload.getRefreshToken()),
                payload.isRememberMe()
        );
    }

    @Override
    public void logout() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("{} user logout succeed", userDetails.getUsername());
    }

    @Override
    public ProceedKey signUp(SignUpPayload payload) {
        if (userService.checkByEmail(payload.getEmail())) {
            throw BaseException.of(EMAIL_ALREADY_REGISTERED);
        }

        Role defaultRole = roleService.getDefaultRole();

        // Stage 1: User insert
        User user = UserEntityMapper.INSTANCE.fromSignUpPayloadToUser(
                payload,
                passwordEncoder.encode(payload.getPassword()),
                defaultRole.getId()
        );
        userService.insert(user);

        // Stage 2: Course insert
        Course course = CourseEntityMapper.INSTANCE.fromSignUpPayload(payload);
        courseService.insertCourse(course);

        // Stage 3: Default branch insert
        branchService.insert(populateDefaultBranchData(payload, course));

        // Stage 4: Employee insert
        employeeService.insert(Employee.builder().userId(user.getId()).build());

        /*
        1. course insert
        2. default branch insert
        3. employee insert
        3.1 employee-branch relation (many-to-many) delete branch_id and type in employees
        4. sending otp (email)
        5. verification otp
        6. login - if user is not confirmed, user can't log in system
         */

        return ProceedKey.builder().proceedKey(otpProceedTokenManager.generate(user)).build();
    }

    @Override
    public void signUpOTP(SignUpOTPChannelRequest payload) {
        User user = userService.getById(
                otpProceedTokenManager.getId(payload.getProceedKey())
        );
        OTPFactory.handle(payload.getChannel()).send(
                SendOTPDto.of(payload.getChannel().getTarget(user), String.format("otpsignup-%s", user.getId()))
        );
    }

    @Override
    public void signUpOTPConfirmation(SignUpOTPRequest payload) {
        // TODO: (IT) Move these codes to separate service. This service can be OTPService
        User user = userService.getById(
                otpProceedTokenManager.getId(payload.getProceedKey())
        );
        final String otp = redisService.get(
                String.format("otpsignup-%s", user.getId())
        );
        if (payload.getOtp().equals(otp)) {
            user.setStatus(UserStatus.ACTIVE);
            userService.update(user);
            log.info("User confirmed!");
        } else {
            // TODO: (IT) Customize exception otp not found or something like this
            throw BaseException.unexpected();
        }
    }

    @Override
    public void setAuthentication(String email) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities())
        );
    }

    // private util methods

    private void authenticate(LoginPayload payload) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(payload.getEmail(), payload.getPassword())
            );
        } catch (AuthenticationException e) {
            throw e.getCause() instanceof BaseException ?
                    (BaseException) e.getCause() :
                    BaseException.unexpected();
        }
    }

    private LoginResponse prepareLoginResponse(String email, boolean rememberMe) {
        User user = userService.getByEmail(email);
        return LoginResponse.builder()
                .accessToken(accessTokenManager.generate(user))
                .refreshToken(refreshTokenManager.generate(
                        RefreshTokenDto.builder()
                                .user(user)
                                .rememberMe(rememberMe)
                                .build()
                ))
                .build();
    }

    private Branch populateDefaultBranchData(SignUpPayload payload, Course course) {
        // TODO: customize field setters with EntityMapper
        return Branch.builder()
                .name(COURSE_BRANCH_DEFAULT_PATTERN.formatted(payload.getCourseName()))
                .status(BranchStatus.ACTIVE)
                .address(payload.getAddress())
                .courseId(course.getId())
                .build();
    }

}
