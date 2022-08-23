package uk.ac.bangor.cs.ice2002.group5.procurementsystem.repository;


import org.springframework.data.repository.CrudRepository;

import uk.ac.bangor.cs.ice2002.group5.procurementsystem.security.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
	
}
