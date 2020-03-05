package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



	//Internalization (for language)
		@Bean
	public LocaleResolver localeResolver()
	{
		SessionLocaleResolver localeResolver=new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);

		return localeResolver;
	}

	@Bean
	public ResourceBundleMessageSource bundleMessageSource()
	{
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("messages");				//This is filename
		return messageSource;
	}


}

