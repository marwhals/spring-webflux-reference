package org.webflux_reference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 * Change annotations for respective package
 */
@SpringBootApplication(scanBasePackages = "org.webflux_reference.streaming")
@EnableR2dbcRepositories(basePackages = "org.webflux_reference.streaming.repository")
public class WebFluxPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFluxPlaygroundApplication.class, args);
	}

}