package uk.ac.bangor.cs.ice2002.group5.procurementsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import uk.ac.bangor.cs.ice2002.group5.procurementsystem.repository.UserRepository;

/**
 * Find User by Username Class
 * 
 * @author Ethan Quilter
 *
 */

@Component
public class RepositoryBasedUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return repo.findByUsername(username);
	}

}
