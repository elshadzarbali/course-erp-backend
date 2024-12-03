package com.mycompany.courseerpbackend;

import com.mycompany.courseerpbackend.models.enums.user.UserStatus;
import com.mycompany.courseerpbackend.models.mybatis.user.User;
import com.mycompany.courseerpbackend.models.properties.security.SecurityProperties;
import com.mycompany.courseerpbackend.services.security.AccessTokenManager;
import com.mycompany.courseerpbackend.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class CourseErpBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CourseErpBackendApplication.class, args);
	}

	private final SecurityProperties securityProperties;

	private final AccessTokenManager accessTokenManager;

	private final UserService userService;
	private final PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		// inserting user manually
//		User user = User.builder()
//				.name("Elshad")
//				.surname("Zarbalizade")
//				.email("elshad@gmail.com")
//				.password(passwordEncoder.encode("password"))
//				.roleId(1L)
//				.phoneNumber("342433432")
//				.status(UserStatus.ACTIVE)
//				.build();
//
//		System.out.println(accessTokenManager.generate(user));
//
//		userService.insert(user);
//
//		System.out.println(userService.getByEmail("elshad@gmail.com"));


	}
}
