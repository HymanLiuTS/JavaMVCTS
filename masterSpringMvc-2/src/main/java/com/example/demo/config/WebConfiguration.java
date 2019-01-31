package com.example.demo.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.date.CNLocalDateFormatter;

/**
 * @author Hyman
 *  ��spring mvc�Զ�������
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatterForFieldType(LocalDate.class, new CNLocalDateFormatter());
	}

}
