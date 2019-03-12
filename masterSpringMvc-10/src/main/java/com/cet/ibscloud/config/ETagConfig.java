package com.cet.ibscloud.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@Configuration
public class ETagConfig {
	
	public Filter etagFilter() {
		return new ShallowEtagHeaderFilter();
	}

}
