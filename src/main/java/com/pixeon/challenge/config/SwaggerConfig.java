package com.pixeon.challenge.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pixeon.challenge"))
                .paths(regex("/healthcares.*"))
                .build()
                .apiInfo(metaInfo());
    }

    @SuppressWarnings("rawtypes")
	private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Pixeon Tech Challenge API REST",
                "API REST of control over the healthcare institution.",
                "1.0",
                "Terms of Service",
                new Contact("Jefferson", "https://github.com/jeffjanuario",
                        "jefferson_januario@hotmail.com"),
                "Apache License Version 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
}
