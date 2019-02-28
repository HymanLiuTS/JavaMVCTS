package com.cet.ibs.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//撤销自动配置
//@EnableAutoConfiguration(exclude= {SayHelloAutoconfiguration.class})
public class MasterSpringMvc131Application {

	public static void main(String[] args) {
		SpringApplication.run(MasterSpringMvc131Application.class, args);
	}

}
