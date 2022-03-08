package com.luxstech.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    private static final String SCHEME_NAME = "basicAuth";
    private static final String SCHEME = "basic";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("country-api").apiInfo(metadata()).select()
                .apis(RequestHandlerSelectors.basePackage("com.luxstech.controller")).paths(PathSelectors.any()).build();
    }

    public static ApiInfo metadata() {
        return new ApiInfoBuilder().title("Country Rest API Docs on Swagger")
                .description("Swagger Documentation for Understanding the Country based Rest API").version("1.1")
                .license("MIT Licence").licenseUrl("").build();
    }
}
