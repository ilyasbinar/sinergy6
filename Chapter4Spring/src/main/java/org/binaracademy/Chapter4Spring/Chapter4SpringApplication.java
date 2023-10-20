package org.binaracademy.Chapter4Spring;

import org.binaracademy.Chapter4Spring.controller.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter4SpringApplication {

	public static void main(String[] args) {
		HomeController homeController = SpringApplication.run(Chapter4SpringApplication.class, args)
				.getBean(HomeController.class);

		homeController.home();
	}

}
