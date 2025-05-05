package com.gti.insurance_configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.gti.insurance_configuration.client")
@Import({com.gti.security_commons.config.JwtAuthConverter.class,
        com.gti.security_commons.config.SecurityConfiguration.class,
        com.gti.security_commons.config.OpenApiConfig.class
})
public class InsuranceConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceConfigurationApplication.class, args);
	}

}
