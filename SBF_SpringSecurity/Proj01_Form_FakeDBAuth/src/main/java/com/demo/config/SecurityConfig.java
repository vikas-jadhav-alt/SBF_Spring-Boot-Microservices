package com.demo.config;

import static com.demo.config.ApplicationUserRole.STUDENT;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.demo.auth.ApplicationUserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ApplicationUserService applicationUserService;
	
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());

		// Another writing style.
//		   auth.userDetailsService(applicationUserService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
         .csrf().disable()
         .authorizeRequests()
         .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
         .antMatchers("/api/**").hasRole(STUDENT.name())
         .anyRequest()
         .authenticated()
         .and()
         .formLogin()
             .loginPage("/login")
//            .loginProcessingUrl("");
//            .failureUrl("")
             .permitAll()
             .defaultSuccessUrl("/courses", true)
//             .passwordParameter("password")
//             .usernameParameter("username")
         .and()
         .rememberMe()
             .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
             .key("somethingverysecured")
//            .rememberMeParameter("remember-me")
         .and()
         .logout()
             .logoutUrl("/logout")
             .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) // https://docs.spring.io/spring-security/site/docs/4.2.12.RELEASE/apidocs/org/springframework/security/config/annotation/web/configurers/LogoutConfigurer.html
             .clearAuthentication(true)
             .invalidateHttpSession(true)
             .deleteCookies("JSESSIONID", "remember-me")
             .logoutSuccessUrl("/login")
            .and()
            .sessionManagement() //Controlling the Session Managemment
            	.maximumSessions(2)
            	.maxSessionsPreventsLogin(true);
	}

//	@Override
//	@Bean
//	protected UserDetailsService userDetailsService() {
//		UserDetails annaSmithUser = User.builder().username("annasmith").password(passwordEncoder.encode("password"))
////	                .roles(STUDENT.name()) // ROLE_STUDENT
//				.authorities(STUDENT.getGrantedAuthorities()).build();
//
//		UserDetails lindaUser = User.builder().username("linda").password(passwordEncoder.encode("password123"))
////	                .roles(ADMIN.name()) // ROLE_ADMIN
//				.authorities(ADMIN.getGrantedAuthorities()).build();
//
//		UserDetails tomUser = User.builder().username("tom").password(passwordEncoder.encode("password123"))
//				.roles(ADMINTRAINEE.name()) // ROLE_ADMINTRAINEE
//				.authorities(ADMINTRAINEE.getGrantedAuthorities()).build();
//
//		return new InMemoryUserDetailsManager(annaSmithUser, lindaUser, tomUser);
//
//	}
}
