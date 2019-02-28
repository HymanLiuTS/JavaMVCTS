package codenest.autoconfigdemo.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@EnableConfigurationProperties({ SayHelloProperties.class })
@ConditionalOnClass({ SayHello.class })
@ConditionalOnProperty(prefix = "hello", value = "enable", matchIfMissing = true)
public class SayHelloAutoconfiguration {

	@Resource
	private SayHelloProperties sayHelloProperties;

	@Bean
	@ConditionalOnMissingBean({ SayHello.class })
	public SayHello sayHello() {
		SayHello sayHello = new SayHello();
		sayHello.setHelloMsg(sayHelloProperties.getHelloMessage());
		return sayHello;
	}
}
