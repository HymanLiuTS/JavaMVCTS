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
 * @author Hyman ��spring mvc�Զ�������
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Bean
	public LocaleResolver localeResolver() {
		//FixedLocaleResolver slr = new FixedLocaleResolver();
	    //��session�м����ͱ��������Ϣ
		//SessionLocaleResolver slr = new SessionLocaleResolver();
		//��Cookie�м����ͱ��������Ϣ
		CookieLocaleResolver slr = new CookieLocaleResolver();
		// Ĭ������
		// slr.setDefaultLocale(Locale.US);
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		// ������
		lci.setParamName("lang");
		return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

}
