package uk.ac.bangor.cs.ice2002.group5.procurementsystem.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.ac.bangor.cs.ice2002.group5.procurementsystem.repository.RequisitionRepository;
import uk.ac.bangor.cs.ice2002.group5.procurementsystem.security.User;

/**
 * Controller to handle filtered database retrieved data for requisitions
 * @author Ethan Quilter
 *
 */

@RequestMapping(value = "/requisitions")
@Controller
public class RequisitionQueryController {
	@Autowired // 
	private RequisitionRepository repo;

	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String RequisitionList(Model uiModel) {
		uiModel.addAttribute("requisitions", repo.findAll());
		uiModel.addAttribute("requisitionCount", repo.count());
		return "/requisitions/requisitionsList";
	}
	
	
	@RequestMapping(value = "/requisitionList/User", method = RequestMethod.GET)
	public String RequisitionListByID(Model uiModel) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)auth.getPrincipal();
		uiModel.addAttribute("currentUser", user);	
		uiModel.addAttribute("requisitionList", repo.findByUserID(user.getUserID()));
		return "/requisitions/requisitionsList";
	}
	
	@RequestMapping(value = "/requisitionList/BudgetHolder", method = RequestMethod.GET)
	public String RequisitionListByStateBH(Model uiModel) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)auth.getPrincipal();
		uiModel.addAttribute("currentUser", user);	
		uiModel.addAttribute("requisitionList", repo.findByRequestState("UNDERREVIEW"));
		return "/requisitions/requisitionsList";
	}
	
	@RequestMapping(value = "/requisitionList/RequisitionOfficer", method = RequestMethod.GET)
	public String RequisitionListByStateRO(Model uiModel) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)auth.getPrincipal();
		uiModel.addAttribute("currentUser", user);	
		uiModel.addAttribute("requisitionList", repo.findByRequestState("PLACINGORDER"));
		return "/requisitions/requisitionsList";
	}
	
	@RequestMapping(value = "/requisitionList/FinanceOfficer", method = RequestMethod.GET)
	public String RequisitionListByStateFO(Model uiModel) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)auth.getPrincipal();
		uiModel.addAttribute("currentUser", user);	
		uiModel.addAttribute("requisitionList", repo.findByRequestState("AWAITINGPAYMENT"));
		return "/requisitions/requisitionsList";
	}
}
