package com.mycompany.courseerpbackend.configs;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Authorization",
        scheme = "bearer",
        bearerFormat = "JWT",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {

    // todo: fill real data
    @Bean
    public OpenAPI myOpenAPI() {
        Contact contact = new Contact();
        contact.setEmail("mycompany@mycompany.com");
        contact.setName("My Company");
        contact.setUrl("https://mycompany.com");

        Info info = new Info()
                .title("Course ERP API")
                .version("1.0")
                .contact(contact)
                .description("My Company Description")
                .termsOfService("http://mycompany.com/terms");

        return new OpenAPI()
                .info(info)
                .addSecurityItem(
                        new SecurityRequirement()
                                .addList("Authorization")
                );
    }
}
