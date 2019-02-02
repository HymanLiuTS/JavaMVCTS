package com.example.demo.config;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
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

	@Bean//定义全局异常处理方法一
	public WebServerFactoryCustomizer containerCustomizer() {
		WebServerFactoryCustomizer container = new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {

			@Override
			public void customize(ConfigurableWebServerFactory factory) {
				factory.addErrorPages(new ErrorPage(MaxUploadSizeExceededException.class, "/uploadError"));
			}
		};
		return container;
	}
}
