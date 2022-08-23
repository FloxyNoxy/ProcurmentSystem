package uk.ac.bangor.cs.ice2002.group5.procurementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import uk.ac.bangor.cs.ice2002.group5.procurementsystem.security.RepositoryBasedUserDetailsService;

/**
 * Class is responsible of giving access to user roles according to their privileges.
 * @author Ethan Quilter
 */
@Component
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private RepositoryBasedUserDetailsService userDetailsService;
	
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll();
		
		http.authorizeRequests()
		.antMatchers("/users/**")
		.hasAnyRole("ADMIN");
		
		http.authorizeRequests()
		.antMatchers("/requisitions/create/**")
		.hasAnyRole("BUDGETHOLDER", "STAFF", "REQUISITIONOFFICER", "FINANCEOFFICER");
		
		http.authorizeRequests()
		.antMatchers("/requisitions/requisitionList/User/**")
		.hasAnyRole("BUDGETHOLDER", "STAFF", "REQUISITIONOFFICER", "FINANCEOFFICER");
		
		http.authorizeRequests()
		.antMatchers("/requisitions/requisitionList/BudgetHolder/**")
		.hasAnyRole("BUDGETHOLDER");
		
		http.authorizeRequests()
		.antMatchers("/requisitions/requisitionList/RequisitionOfficer/**")
		.hasAnyRole("REQUISITIONOFFICER");
		
		http.authorizeRequests()
		.antMatchers("/requisitions/requisitionList/FinanceOfficer/**")
		.hasAnyRole("FINANCEOFFICER");
		
		http.formLogin().loginPage("/login").loginProcessingUrl("/process_login")
											.permitAll();
		
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"));
		
		http.requestCache();
		
		http.userDetailsService(userDetailsService());
	}
	
	public UserDetailsService userDetailsService() {
		return userDetailsService;
	}

	@Bean // The return from this method also registered in context
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SpringSecurityDialect springSecurityDialect() {
	    return new SpringSecurityDialect();
	}
}
