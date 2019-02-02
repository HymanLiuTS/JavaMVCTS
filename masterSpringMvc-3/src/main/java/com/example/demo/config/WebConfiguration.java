package com.example.demo.config;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * @author Hyman 对spring mvc自定义配置
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Bean
	public LocaleResolver localeResolver() {
		//FixedLocaleResolver slr = new FixedLocaleResolver();
	    //在session中检索和保存地域信息
		//SessionLocaleResolver slr = new SessionLocaleResolver();
		//在Cookie中检索和保存地域信息
		CookieLocaleResolver slr = new CookieLocaleResolver();
		// 默认语言
		// slr.setDefaultLocale(Locale.US);
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		// 参数名
		lci.setParamName("lang");
		return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

}
