package com.gk.app;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.gk.dao")
@EntityScan("com.gk.*") 
@ComponentScan(basePackages = "com.gk.*")
/**
 * 
 * @author Gangadhar
 *
 */
public class CrudApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(CrudApplication.class, args);
	}
	/**
	 * Implementation of LocaleResolver that simply uses the primary locale specified in the 
	 * "accept-language" header of the HTTP request (that is, the locale sent by the client 
	 * browser, normally that of the client's OS)
	 * Note: Does not support setLocale, since the accept header can only be changed 
	 * through changing the client's locale settings.
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localResolver = new AcceptHeaderLocaleResolver();
		localResolver.setDefaultLocale(Locale.US);
		return localResolver;
	}
	/**
	 * below commented method is not required because the 
	 * property spring.messages.basename=messages is defined in the application.properties 
	 * and it will be autoconfigured by spring boot
	 */
	/*public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
		bundleMessageSource.setBasename("messages");
		return bundleMessageSource;
	}*/
}
