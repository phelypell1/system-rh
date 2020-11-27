package br.com.rhsystem.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)//
                //.securitySchemes(new ArrayList<>(Arrays.asList(apiKey())))//
//                .tags(new Tag("users", "Operations about users"))//
//                .tags(new Tag("ping", "Just a ping"))//
                .genericModelSubstitutes(Optional.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Exemplo de projeto TCC para o Renato")
                .title("Projeto do Felipe")
                .description("API baseada no OpenAPI(Swagger), Spring Boot 2.x.x.RELEASE, JWT, Swagger-ui 2.9.x, Postgresql, Java 8 e Lombok")
                .termsOfServiceUrl("http://springfox.io")
                .contact(new Contact("Fatesg"
                        , "https://fasam.edu.br"
                        , "email@email.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("1.0.0")
                .build();
    }

    private Api apiKey() {
        return (Api) new ApiKey("Bearer %token", "Authorization", "Header");
    }
}