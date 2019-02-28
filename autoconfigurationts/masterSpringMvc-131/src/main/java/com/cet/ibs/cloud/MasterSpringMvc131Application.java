package com.cet.ibs.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"codenest.autoconfigdemo.demo","com.cet.ibs.cloud.controller"})
public class MasterSpringMvc131Application {

	public static void main(String[] args) {
		SpringApplication.run(MasterSpringMvc131Application.class, args);
	}

}
