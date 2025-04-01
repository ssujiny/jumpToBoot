package com.mysite.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
					.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
		/* h2 DB 사용시 h2콘솔 페이지 예외 처리
		 * 
		 *  csrf((csrf) -> csrf
		 *  	.ignoringRequestMatchers(new AntPathRequestMatcher
		 *  ("/h2-console/**")))
		 *  .headers((headers) -> headers
		 *  	.addHeaderWriter(new XFrameOptionHeaderWriter(
		 *  		XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN )))
		 *  
		 */
			// 스프링 시큐리티의 로그인 설정 담당
			.formLogin((formLogin) -> formLogin
					.loginPage("/user/login")
					.defaultSuccessUrl("/"))
					.logout((logout) -> logout
							.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
							.logoutSuccessUrl("/")
							// 로그아웃시, 생성된 사용자 세션 삭제
							.invalidateHttpSession(true))
							
			;
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
