package com.project.plans.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProjectPlansSchedulerApplication {
	
	// allow cross-origin
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// localhost:4200 is the default port for angular. Add it into allowedOrigins with allowedMethods configured as POST and GET.
				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("POST", "GET");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectPlansSchedulerApplication.class, args);
	}
}
