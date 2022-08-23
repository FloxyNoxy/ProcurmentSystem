package web;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import repository.RequisitionRepository;
import security.User;

/**
 * User Authentication class
 * 
 * @author Ethan Quilter
 *
 */
@Component(value="AuthenticationService")
public class AuthenticationService implements PermissionEvaluator {
	
	@Autowired
	private RequisitionRepository repo;

	public boolean hasAccess(Authentication auth, int requisitionid) {
		User user = (User)auth.getPrincipal();
		RequisitionRequest requisition = repo.findById(requisitionid).get();
		
		if(user.getUserID() == requisition.getUserID()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
	      if ((authentication == null) || (targetDomainObject == null) || !(permission instanceof String)){
	            return false;
	        } else {
	        	return hasAccess(authentication, (int) targetDomainObject);
	        }
	      
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
        if ((authentication == null) || (targetType == null) || !(permission instanceof String)) {
            return false;
        } else {
        	return true;
        }
	}


}
