/**
 * 
 */
package com.nopaper.work.master;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * 
 */
@Configuration
@OpenAPIDefinition
public class MasterWebConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public OpenAPI baseOpenAPI() {
		return new OpenAPI().info(new Info().title("Master - No Paper Work").version("1.0.0").description("Master Microservice for ShareHelpers"));
	}

}

