package JDBC_ERS_DAO;

import java.util.List;
import ERS_Actors.ERS_Request;

public interface ERS_DAO {
	public List<ERS_Request> getAllRequests();
	public List<ERS_Request> getRequestByEmp(int emp_id);
	public ERS_Request getRequestByReq(int req_id);
	public int createRequest(ERS_Request req);
	public int updateRequest(ERS_Request req);
	public int updateRequest(List<ERS_Request> req);
	public int getNextReqId();
}
