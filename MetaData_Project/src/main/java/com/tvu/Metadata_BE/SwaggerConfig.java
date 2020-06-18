package com.tvu.Metadata_BE;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket crosscodeApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("public-api")
				.apiInfo(apiInfo(Constants.API.NAME_API))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.tvu.Metadata_BE"))
				.paths(PathSelectors.any()).build();
	}
	private ApiInfo apiInfo(String module) {
		return new ApiInfoBuilder()
				.title("TVU " + module + " API")
				.description("List of all the Crosscode " + module + " APIs")
				.license("Apache License Version 2.0")
				.licenseUrl("http://www.apache.org")
				.version("1.0")
				.build();
	}
}
