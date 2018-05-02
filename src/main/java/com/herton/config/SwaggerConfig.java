package com.herton.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis((RequestHandler input) -> {
                        if(input == null) {
                            return false;
                        }
                        String pkgName = input.getHandlerMethod().getMethod().getDeclaringClass().getPackage().getName();
                        return pkgName.startsWith("com.herton");
                    }
                )
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("进销存API")
                .description("进销存API")
                .contact("tang he")
                .version("1.0")
                .build();
    }
}
