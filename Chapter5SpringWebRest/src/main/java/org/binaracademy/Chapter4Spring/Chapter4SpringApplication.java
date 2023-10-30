package org.binaracademy.Chapter4Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Chapter4SpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter4SpringApplication.class, args);
	}

}
