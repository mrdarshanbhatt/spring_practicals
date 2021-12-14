package com.mvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("private-api").apiInfo(metadata()).select()
				.apis(RequestHandlerSelectors.basePackage("com.mvc.controller")).paths(PathSelectors.any()).build();
	}

	public static ApiInfo metadata() {
		return new ApiInfoBuilder().title("UserManagment RESTApi Docs.")
				.description("Usermagment API build for the testing purpose of swagger documentation.").version("1.1")
				.license("MIT Licence").licenseUrl("").build();
	}
}
