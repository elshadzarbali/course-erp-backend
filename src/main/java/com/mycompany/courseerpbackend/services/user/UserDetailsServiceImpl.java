package com.mycompany.courseerpbackend.services.user;

import com.mycompany.courseerpbackend.exception.BaseException;
import com.mycompany.courseerpbackend.models.enums.response.ErrorResponseMessages;
import com.mycompany.courseerpbackend.models.mybatis.user.User;
import com.mycompany.courseerpbackend.models.security.LoggedInUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.mycompany.courseerpbackend.utils.CommonUtils.throwIf;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    // todo: currently our system supports only email login,
    //  but in the future we have to implement phone number login
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByEmail(username);

        throwIf(() -> !user.isActive(), BaseException.of(ErrorResponseMessages.USER_NOT_ACTIVE));

        return new LoggedInUserDetails(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
