package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * // @formatter:off,设置不用進行安全认证的路径，如果不设置默认全部url都不进行安全认证 http.authorizeRequests()
	 * .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).
	 * permitAll() .anyRequest().fullyAuthenticated() .and()
	 * .formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
	 * .and() .logout().permitAll(); // @formatter:on }
	 */
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic()
		.and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/login","/logout").permitAll()
		.antMatchers(HttpMethod.GET,"/api/users").hasRole("ADMIN")
		.anyRequest().authenticated();
	}
	
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		//scurity5之前使用无需将密码加密
		/*
		 * auth.inMemoryAuthentication().
		 * withUser("user").password("user").roles("USER").and().
		 * withUser("admin").password("admin").roles("USER","ADMIN");
		 */
		 auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).
		 withUser("user1").password(new BCryptPasswordEncoder().encode("123456")).roles("USER").and().
		 withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("USER","ADMIN");
	}

}
