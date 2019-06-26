package ERS_Actors;
/**
 * Description - This class represents an ERS request. The request can return its current status, who requested it, the amount requested, and any other comments on the request.
 * @author mattd
 * @version 1.0.0
 *
 */
public class ERS_Request {//class header
	//class attributes
	private int req_id, emp_id;
	private double amount;
	private String status, comments;
	
	/**
	 * Description - No args constructor that instantiates and ERS_Request with its attributes set to null
	 * @param - nothing.
	 * @returns - nothing.
	 * @throws - nothing.
	 */
	public ERS_Request() {
		
	}
	
	/**
	 * Description - Argument constructor for ERS_Request that is instantiated with the associated parameters as its attributes.
	 * @param req_id - Integer value that represents the ID for the request.
	 * @param emp_id - Integer value the represents the employee or manager that created the request.
	 * @param amount - Double value that represents the amount of money being requested to be reimbursed.
	 * @param status - String that represents the current status of the request.
	 * @param comments - String that represents any additional info pertaining to the request.
	 * @returns - nothing.
	 * @throws - nothing.
	 */
	public ERS_Request(int req_id, int emp_id, double amount, String status, String comments) {
		this.req_id = req_id;
		this.emp_id = emp_id;
		this.amount = amount;
		this.status = status;
		this.comments = comments;
	}
	
	/**
	 * Description - Returns the Employee ID associated with this ERS_Request
	 * @return - Integer value representing the employee ID associated with the ERS_Request
	 * @throws - nothing
	 */
	public int getEmp_id() {
		return emp_id;
	}
	
	/**
	 * Description - Changes the employee ID to a different employee ID associated with this ERS_Request.
	 * @param emp_id - Integer representation of the new employee ID.
	 * @throws - Nothing.
	 */
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
	/**
	 * Description - Returns the amount of money being requested for reimbursement.
	 * @return - Double representation of the amount of money associated with the ERS_Request.
	 * @throws - Nothing.
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * Description - Changes the amount of money being requested for reimbursement
	 * @param amount - Double representation of a new amount of money on this ERS_Request.
	 * @throws - Nothing.
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * Description - Returns the current status of this ERS_Request.
	 * @return - Returns the String representation of the current status of this ERS_Request. Status returned should be: APPROVED, DENIED, or PENDING.
	 * @throws - Nothing.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Description - Change the status of this ERS_Request
	 * @param status - String that will be the new status of this ERS_Request
	 * @throws - Nothing.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Description - Returns a String of comments pertaining to this ERS_Request.
	 * @return - A String representing comments pertaining to this ERS_Request.
	 * @throws - Nothing.
	 */
	public String getComments() {
		return comments;
	}
	
	/**
	 * Description - Overwrites the comments for this ERS_Request.
	 * @param comments - A String containing comments pertaining to this ERS_Request.
	 * @throws - Nothing.
	 */
	public void setComments(String comments) {
		this.comments = comments; //USE A StringBuilder
	}
	/**
	 * Description - Returns the ID that is unique and identifies this specific ERS_Request.
	 * @return - Integer value representing the ID of this ERS_Request.
	 * @throws - Nothing.
	 */
	public int getReq_id() {
		return req_id;
	}
	
	/**
	 * Description - Returns a deep copy of this object
	 * @return - an ERS_Request with the exact same attributes as this object
	 * @throws - Nothing
	 */
	public ERS_Request deepCopy() {
		
		return new ERS_Request(this.req_id, this.emp_id, this.amount, this.status, this.comments);
	}

	@Override
	public String toString() {
		return "ERS_Request [req_id=" + req_id + ", emp_id=" + emp_id + ", amount=" + amount + ", status=" + status
				+ ", comments=" + comments + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + emp_id;
		result = prime * result + req_id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ERS_Request other = (ERS_Request) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (emp_id != other.emp_id)
			return false;
		if (req_id != other.req_id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
	
	

}//end of class
