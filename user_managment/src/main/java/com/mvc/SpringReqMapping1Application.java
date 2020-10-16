package com.mvc;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringReqMapping1Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringReqMapping1Application.class);

		application.setBannerMode(Banner.Mode.CONSOLE);

		application.run(args);

	}

}
