package com.eshopping.product.dashboard.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        List<Parameter> parameterBuilder = Stream.of(new ParameterBuilder()
                .name("Authorization")
                .description("Bearer ")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .build()).collect(Collectors.toList());
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(parameterBuilder)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Product Api", "This api handles product details",
                "1.0", "www.miraclesoft.com", new Contact("Sri", "www.miraclesoft.com", "snagidi@miraclesoft.com"), "License of API",
                "www.miraclesoft.com", Collections.emptyList());
    }

}
