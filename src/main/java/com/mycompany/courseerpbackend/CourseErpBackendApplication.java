package com.mycompany.courseerpbackend;

import com.mycompany.courseerpbackend.models.enums.user.UserStatus;
import com.mycompany.courseerpbackend.models.mybatis.user.User;
import com.mycompany.courseerpbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseErpBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CourseErpBackendApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
//		User user = User.builder()
//				.name("Elshad")
//				.surname("Zarbalizade")
//				.status(UserStatus.ACTIVE)
//				.roleId(1L)
//				.email("elshad@gmail.com")
//				.phoneNumber("501111111")
//				.password("myPassword")
//				.build();
//		userRepository.insert(user);
//
//		System.out.println(String.format("%s id user inserted", user.getId()));
	}
}
