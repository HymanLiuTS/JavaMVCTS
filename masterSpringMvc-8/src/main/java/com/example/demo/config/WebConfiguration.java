package com.example.demo.config;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.UrlPathHelper;

import com.example.demo.Interceptor.LoginInterceptor;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Hyman ��spring mvc�Զ������ã�����ʹ���Զ����ʱ���ʽ
 */
@Configuration
@EnableSwagger2
public class WebConfiguration implements WebMvcConfigurer {

	//@Autowired
	//RightsInterceptor rightsInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 登录拦截的管理器
		InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor()); // 拦截的对象会进入这个类中进行判断
		registration.addPathPatterns("/**"); // 所有路径都被拦截
		registration.excludePathPatterns("/", "/login", "/error", "/static/**", "/logout"); // 添加不拦截路径

	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		UrlPathHelper urlPathHelper = new UrlPathHelper();
		urlPathHelper.setRemoveSemicolonContent(false);
		configurer.setUrlPathHelper(urlPathHelper);
	}

	@Bean
	public Docket userApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(path -> path.startsWith("/api/")).build();
	}
}
