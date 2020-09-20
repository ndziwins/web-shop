package pw.ddteam.webshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("user1")
				.roles("USER")
				.build();
		
		UserDetails shop = User.withDefaultPasswordEncoder()
				.username("shop")
				.password("shop1")
				.roles("SHOP")
				.build();
		
		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("admin1")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, shop, admin);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic().and().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/products").permitAll()
		.antMatchers(HttpMethod.POST, "/products").hasAnyRole("SHOP", "ADMIN")
		.antMatchers(HttpMethod.GET, "/products/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/products/{id}").hasAnyRole("SHOP","ADMIN")
		.antMatchers(HttpMethod.PUT, "/products//buy/{id}").hasRole("USER")
		.anyRequest().hasRole("ADMIN")
		.and()
		.formLogin().permitAll()
		.and()
		.logout().permitAll()
		.and()
		.csrf().disable();
		
		
	}
	
	
	
	
}
