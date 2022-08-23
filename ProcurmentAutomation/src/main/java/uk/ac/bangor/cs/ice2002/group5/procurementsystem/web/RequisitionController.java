package uk.ac.bangor.cs.ice2002.group5.procurementsystem.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.ac.bangor.cs.ice2002.group5.procurementsystem.repository.RequisitionRepository;
import uk.ac.bangor.cs.ice2002.group5.procurementsystem.security.User;


/**
 * COntroller to handle all GET and Post requests for all requisitions
 * @author Ethan Quilter
 *
 */
@Controller
@RequestMapping(value = "/requisitions")
public class RequisitionController {
	@Autowired // instance injected into MathsRequest Class
	private RequisitionRepository repo;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String requestForm(Model uiModel) {
		uiModel.addAttribute("requisition", new RequisitionRequest());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)auth.getPrincipal();
		uiModel.addAttribute("currentUser", user);
		
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String dateString = formatter.format(date);
		uiModel.addAttribute("date", dateString);
		uiModel.addAttribute("requestState", RequisitionRequest.requestState.values());
		return "/requisitions/requisitionsform";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String RequisitionRequest(Model uiModel, @ModelAttribute RequisitionRequest requisition) {

		uiModel.addAttribute("requisition", requisition);
		repo.save(requisition);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)auth.getPrincipal();
		uiModel.addAttribute("currentUser", user);
		return "redirect:/requisitions/requisitionList/User";
	}
	
	@RequestMapping(value = "/BudgetHolder/decline/{id}", method = RequestMethod.GET)
	public String declineRequisition(Model uiModel, @PathVariable("id") int primaryKey) {
		Optional<RequisitionRequest> request = repo.findById(primaryKey);
		RequisitionRequest requisition = request.get();
		requisition.setRequestState("DECLINED");
		repo.save(requisition);
		return "redirect:/requisitions/requisitionList/BudgetHolder";
	}
	
	@RequestMapping(value = "/BudgetHolder/accept/{id}", method = RequestMethod.GET)
	public String acceptRequisitionBH(Model uiModel, @PathVariable("id") int primaryKey) {
		Optional<RequisitionRequest> request = repo.findById(primaryKey);
		RequisitionRequest requisition = request.get();
		requisition.setRequestState("PLACINGORDER");
		repo.save(requisition);
		return "redirect:/requisitions/requisitionList/BudgetHolder";
	}
	
	@RequestMapping(value = "/RequisitionOfficer/decline/{id}", method = RequestMethod.GET)
	public String declineRequisitionRO(Model uiModel, @PathVariable("id") int primaryKey) {
		Optional<RequisitionRequest> request = repo.findById(primaryKey);
		RequisitionRequest requisition = request.get();
		requisition.setRequestState("DECLINED");
		repo.save(requisition);
		return "redirect:/requisitions/requisitionList/RequisitionOfficer";
	}
	
	@RequestMapping(value = "/RequisitionOfficer/accept/{id}", method = RequestMethod.GET)
	public String acceptRequisitionRO(Model uiModel, @PathVariable("id") int primaryKey) {
		Optional<RequisitionRequest> request = repo.findById(primaryKey);
		RequisitionRequest requisition = request.get();
		requisition.setRequestState("AWAITINGPAYMENT");
		repo.save(requisition);
		return "redirect:/requisitions/requisitionList/RequisitionOfficer";
	}
	
	@RequestMapping(value = "/FinanceOfficer/decline/{id}", method = RequestMethod.GET)
	public String declineRequisitionFO(Model uiModel, @PathVariable("id") int primaryKey) {
		Optional<RequisitionRequest> request = repo.findById(primaryKey);
		RequisitionRequest requisition = request.get();
		requisition.setRequestState("DECLINED");
		repo.save(requisition);
		return "redirect:/requisitions/requisitionList/FinanceOfficer";
	}
	
	@RequestMapping(value = "/FinanceOfficer/accept/{id}", method = RequestMethod.GET)
	public String acceptRequisitionFO(Model uiModel, @PathVariable("id") int primaryKey) {
		Optional<RequisitionRequest> request = repo.findById(primaryKey);
		RequisitionRequest requisition = request.get();
		requisition.setRequestState("COMPLETED");
		repo.save(requisition);
		return "redirect:/requisitions/requisitionList/FinanceOfficer";
	}
}
