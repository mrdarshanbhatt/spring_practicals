package com.luxstech.configuration;

import springfox.documentation.service.SecurityScheme;

public class SwaggerSecurityScheme extends SecurityScheme {

    protected SwaggerSecurityScheme(String name, String type) {
        super(name, type);
    }

    @Override
    public String getName() {
        return "basicAuth";
    }

    @Override
    public String getType() {
        return "basic";
    }
}
