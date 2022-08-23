package ProcurementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Application start class
 * 
 * @author Ethan Quilter
 *
 */

@SpringBootApplication
@EnableWebSecurity
public class ProcurementSystemApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ProcurementSystemApplication.class, args);
	}

}
