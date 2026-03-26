package Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		/*httpSecurity.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/public")
		
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		return httpSecurity.build();
		
		
		
		http.authorizeHttpRequests()
	    .requestMatchers("/normal/**").hasRole("NORMAL")
	    .requestMatchers("/admin/**").hasRole("ADMIN")
	    .requestMatchers("/public").permitAll()
	    .and()
	    .formLogin();
		
		return http.build();
		*/
		
		  http.authorizeHttpRequests(auth -> auth
			        .requestMatchers(AntPathRequestMatcher.antMatcher("/public"))
			        
			        .permitAll()
			        .requestMatchers(AntPathRequestMatcher.antMatcher("/admin"))
			        .hasRole("ADMIN")
			        .anyRequest().authenticated())
			        .formLogin();
			 return  http.build();     
			        
	}
	
	

}
