package com.gk.swagger.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Gangadhar http://localhost:8081/swagger-ui.html#/ hit this for UI of
 *         documentation
 * 
 *         localhost:8081/v2/api-docs for api specifications
 *         
 *apinfo is used to add info to the api which will be shown in swagger ui
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Gangadahar", "www.gangadhar.com",
			"gangadhar@motorbikes.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("MotorBikes", "MotorBikes Documentation", "1.0",
			"urn:tos", DEFAULT_CONTACT, "MotorBikes 2.0", "http://www.motorbikes_gk.org/licenses/LICENSE-2.0");
	private static final Set<String> DEFAULT_PRODUCES_CONSUMES = new HashSet<>(Arrays.asList("application/json","application/xml"));

	@Bean
	public Docket api() {
		//by adding api info, we are defining our own information about the API which will be useful
		//to end consumer to know the api
		//and we are defining the producer and consumers too like defined below.
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).produces(DEFAULT_PRODUCES_CONSUMES).consumes(DEFAULT_PRODUCES_CONSUMES);
		
	}
}
