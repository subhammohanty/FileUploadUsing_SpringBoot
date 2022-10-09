package com.javatechie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket postApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Java Techie").apiInfo(ApiInfo()).select()
                .paths(regex("/api/employee.*")).build();
    }

    private ApiInfo ApiInfo() {
        return new ApiInfoBuilder().title("Employee Service")
                .description("Sample Documentation Using Swagger2")
                .version("2.0").build();
    }
}
