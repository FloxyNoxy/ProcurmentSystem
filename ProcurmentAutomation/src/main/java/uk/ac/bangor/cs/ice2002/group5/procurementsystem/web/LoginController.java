package uk.ac.bangor.cs.ice2002.group5.procurementsystem.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.ac.bangor.cs.ice2002.group5.procurementsystem.security.User;


@Controller
public class LoginController {

	
	@RequestMapping(value = "/login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/")
	public String defaultPage(Model uiModel) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		try {
			User user = (User) auth.getPrincipal();
			uiModel.addAttribute("currentUser", user);
	    } catch (ClassCastException exc) {
	        return "login";
	    }
		return "index";
	}
	


}
