package com.bd.example.serviceone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ServiceOneApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ServiceOneApplication.class, args);
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServiceOneApplication.class);
    }
}
