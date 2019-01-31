package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.demo.config.PicturesUploadProperties;

@SpringBootApplication
@EnableConfigurationProperties({PicturesUploadProperties.class})
public class MasterSpringMvc2Application {

	public static void main(String[] args) {
		SpringApplication.run(MasterSpringMvc2Application.class, args);
	}

}

