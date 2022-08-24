package uk.ac.bangor.cs.ice2002.group5.procurementsystem.web;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Requisition Constructor class with auto generated ID and defaulted UNDERREVIEW request state
 * @author Ethan Quilter
 *
 */

@Entity
public class RequisitionRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
	@SequenceGenerator(
		    name = "seq_post",
		    initialValue = 46,
		    allocationSize = 1
		)
	@Column(name = "primary_key")
	private int primaryKey;
	
	@Column(nullable = false, length = 255)
	private Long userID;
	
	@Column(nullable = false, length = 255)
	private String dateSubmitted;
	
	@Column(nullable = false, length = 255)
	private String name;
	
	@Column(nullable = false, length = 255)
	private String roomNumber;
	
	@Column(nullable = false, length = 255)
	private String email;
	
	@Column(nullable = false, length = 255)
	private String supplierName;
	
	@Column(nullable = true, length = 255)
	private String supplierAddress;
	
	@Column(nullable = false, length = 255)
	private String supplierEmail;
	
	@Column(nullable = false, length = 255)
	private String supplierPhoneNumber;
	
	@Column(nullable = false, length = 255)
	private String item;
	
	@Column(nullable = true, length = 255)
	private String itemDescription;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	private float estCost;
	
	@Column(nullable = false)
	private boolean isRecurring;
	
	
	
	public String getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getSupplierEmail() {
		return supplierEmail;
	}
	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}
	public String getSupplierPhoneNumber() {
		return supplierPhoneNumber;
	}
	public void setSupplierPhoneNumber(String supplierPhoneNumber) {
		this.supplierPhoneNumber = supplierPhoneNumber;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public boolean isRecurring() {
		return isRecurring;
	}
	public void setRecurring(boolean isRecurring) {
		this.isRecurring = isRecurring;
	}

	@Column(length = 255)
	private String requestState = "UNDERREVIEW";
	
	
	
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getRequestState() {
		return requestState;
	}
	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}
	public int getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}
	public float getEstCost() {
		return estCost;
	}
	public void setEstCost(float estCost) {
		this.estCost = estCost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	public enum requestState {
		UNDERREVIEW, PLACINGORDER, AWAITINGPAYMENT, COMPLETED, DECLINED
	}
}
