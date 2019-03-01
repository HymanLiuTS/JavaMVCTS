package codenest.JavaConfigBean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import codenest.JavaConfigBean.domain.ColorInk;
import codenest.JavaConfigBean.domain.Printer;

@Configuration
public class JavaConfig {

	@Bean(initMethod = "init", destroyMethod = "destroy")
	@Scope("singleton")
	public ColorInk colorInk() {
		return new ColorInk();
	}

	@Bean
	public Printer printer() {
		return new Printer();
	}
}
