package com.cet.ibs.cloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@EnableWebMvc//放开@EnableWebMvc注解，会完全替代掉原来spring boot原来的自动配置
@Configuration//使用Configuration注解可以接管spring boot原来的自动配置
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

}
