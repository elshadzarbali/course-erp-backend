package com.mycompany.courseerpbackend;

import com.mycompany.courseerpbackend.models.enums.user.UserStatus;
import com.mycompany.courseerpbackend.models.mybatis.country.Country;
import com.mycompany.courseerpbackend.models.mybatis.user.User;
import com.mycompany.courseerpbackend.models.properties.security.SecurityProperties;
import com.mycompany.courseerpbackend.services.country.CountryService;
import com.mycompany.courseerpbackend.services.otp.OTPProceedTokenManager;
import com.mycompany.courseerpbackend.services.security.AccessTokenManager;
import com.mycompany.courseerpbackend.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

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
	private final CountryService countryService;

	private final OTPProceedTokenManager otpProceedTokenManager;

	@Override
	public void run(String... args) throws Exception {

		User user = userService.getByEmail("elshad@gmail.com");

		String token = otpProceedTokenManager.generate(user);

		System.out.println(token);

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

//		testingCountryService();


	}

	private void testingCountryService() {
//		// insert
//		List<Country> countries = new ArrayList<>();
//		countries.add(new Country("Azerbaijan"));
//		countries.add(new Country("Turkey"));
//		countries.add(new Country("Georgia"));
//		countries.add(new Country("Russia"));
//		countries.add(new Country("Iran"));
//		countries.add(new Country("United States"));
//
//		for (Country country : countries) {
//			countryService.insert(country);
//		}

		// findAll
		List<Country> all = countryService.findAll();
		System.out.println("All countries: \n" + all);

		// getById
		Country foundCountry = countryService.findById(2L);
		System.out.println("Found country: \n" + foundCountry);

		// update
		foundCountry.setName("New Country4");
		countryService.update(foundCountry);

		// getById after update
		Country foundCountryAfterUpdate = countryService.findById(2L);
		System.out.println("Found country: \n" + foundCountryAfterUpdate);
	}
}
