package com.mnemonic.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableJpaRepositories("com.mnemonic.respositories")
@EntityScan("com.mnemonic.entity")
@ComponentScan("com.mnemonic.adapter")
@ComponentScan("com.mnemonic.service")
@ComponentScan("com.mnemonic.api")
@ComponentScan("com.mnemonic")
@EnableSwagger2
public class MnemonicPasswordApplication  {

	
	
	public static void main(String[] args) {
		SpringApplication.run(MnemonicPasswordApplication.class, args);
		
	}
	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//				.allowedMethods("GET", "POST", "PUT", "DELETE")
//				.allowedOrigins("*");
//			}
//		};
//	}
	
}
	

	
	
	


