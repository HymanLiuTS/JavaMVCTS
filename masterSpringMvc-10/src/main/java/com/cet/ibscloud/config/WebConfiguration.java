package com.cet.ibscloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Hyman ��spring mvc�Զ������ã�����ʹ���Զ����ʱ���ʽ
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**")
				.addResourceLocations("classpath:/static/js/")
				.setCachePeriod(12);
	}
}
