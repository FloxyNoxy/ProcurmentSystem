package uk.ac.bangor.cs.ice2002.group5.procurementsystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uk.ac.bangor.cs.ice2002.group5.procurementsystem.web.RequisitionRequest;

/**
 * Interface for Requisitions
 * 
 * @author Ethan Quilter
 *
 */

@Repository
public interface RequisitionRepository extends CrudRepository<RequisitionRequest, Integer>{

	
	List<RequisitionRequest> findAllByOrderByPrimaryKeyDesc();

	List<RequisitionRequest> findBySupplierName(String supplierName);

	List<RequisitionRequest> findAllByOrderByUserID();
	
	List<RequisitionRequest> findAllByOrderBySupplierName();

	List<RequisitionRequest> findByUserID (Long userID);
	
	List<RequisitionRequest> findByRequestState(String requestState);
}
