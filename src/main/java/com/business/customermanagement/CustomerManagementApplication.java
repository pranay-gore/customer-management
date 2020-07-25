package com.business.customermanagement;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CustomerManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
			    .select()
			    .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
			    .paths(PathSelectors.any())
			    .build()
			    .apiInfo(metaData());
	}
	
	 private ApiInfo metaData() {
	        ApiInfo apiInfo = new ApiInfo("Customer Management Rest API",
	        		"This is a Swagger Spec for the Rest APIs exposed in Customer Management Application.", 
	        		"1.0.0", "",
	        		new Contact("ABC Inc.", "www,abn.com", "abc@gmail.com"), "", "", new ArrayList<>());
	        return apiInfo;
	    }
	
}
