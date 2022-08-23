package uk.ac.bangor.cs.ice2002.group5.procurementsystem.security;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import uk.ac.bangor.cs.ice2002.group5.procurementsystem.repository.UserRepository;

/**
 * @author Ethan Quilter
 *
 */
@Component
public class FirstUserSecurityConfigurer {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder pwEncoder;
	
	@PostConstruct // Run after all injection
	public void checkAndCreateFirstUser() {
		
		Logger LOG = LoggerFactory.getLogger(FirstUserSecurityConfigurer.class);
		
		if(repo.count() == 0) {
			LOG.warn("No users found in DB, creating default user.");
			User u = new User();
			u.setPassword(pwEncoder.encode("ProcurementSystem"));
			u.setUsername("admin");
			u.setRole("ADMIN");
			u.setEmail("1");
			u.setFName("1");
			u.setLName("1");
			u.setPhoneNumber("1");
			u.setRoomNumber("1");
			
			repo.save(u);
			LOG.warn("Default user created");
		}
		
	}
	
}
