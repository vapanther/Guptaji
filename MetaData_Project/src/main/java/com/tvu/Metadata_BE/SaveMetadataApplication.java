package com.tvu.Metadata_BE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan("com.tvu.*")
@SpringBootApplication
@EnableScheduling
public class SaveMetadataApplication {
	public static void main(String[] args) {
		SpringApplication.run(SaveMetadataApplication.class, args);
	}
}
