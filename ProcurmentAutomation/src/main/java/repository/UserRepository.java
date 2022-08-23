package repository;


import org.springframework.data.repository.CrudRepository;

import security.User;

/**
 * Interface for Users
 * 
 * @author Ethan Quilter
 *
 */

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
	
}
