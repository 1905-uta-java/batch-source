package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao{

	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		String sql = "SELECT * FROM REIMBURSEMENTS";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);) {
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				int id = rs.getInt("RE_ID");
				r.setId(id);
				int amount = rs.getInt("RE_AMOUNT");
				r.setAmount(amount);
				String reason = rs.getString("RE_REASON");
				r.setReason(reason);
				String status = rs.getString("RE_STATUS");
				r.setStatus(status);
				int completedBy = rs.getInt("RE_COMPLETEDBY");
				r.setCompletedBy(completedBy);
				int num = rs.getInt("RE_NUM");
				r.setNum(num);	
				
				reimbursements.add(r);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursements;
	}

	@Override
	public int submitReimbursement(Reimbursement r) {
		int reimbursementsAdded = 0;

		String sql = "INSERT INTO REIMBURSEMENTS VALUES (?,?,?,?,?,?)";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, r.getId());
			ps.setInt(2, r.getAmount());
			ps.setString(3, r.getReason());
			ps.setString(4, r.getStatus());
			ps.setInt(5, r.getCompletedBy());
			ps.setInt(6, r.getNum());

			
			reimbursementsAdded = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursementsAdded;
		
	}

	@Override
	public List<Reimbursement> getReimbursementById(int empId) {
		List<Reimbursement> reimbursements = new ArrayList<>();

		String sql = "SELECT * FROM REIMBURSEMENTS R JOIN EMPLOYEES E ON R.RE_ID = E.EMP_ID WHERE R.RE_ID = ?";

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
		
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				int id = rs.getInt("RE_ID");
				r.setId(id);
				int amount = rs.getInt("RE_AMOUNT");
				r.setAmount(amount);
				String reason = rs.getString("RE_REASON");
				r.setReason(reason);
				String status = rs.getString("RE_STATUS");
				r.setStatus(status);
				int completedBy = rs.getInt("RE_COMPLETEDBY");
				r.setCompletedBy(completedBy);
				int num = rs.getInt("RE_NUM");
				r.setNum(num);
				
				reimbursements.add(r);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursementByStatus(String status) {
		List<Reimbursement> reimbursements = new ArrayList<>();


		String sql = "SELECT * FROM REIMBURSEMENTS R JOIN EMPLOYEES E ON R.RE_ID = E.EMP_ID WHERE R.RE_STATUS = ?";

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
				
				ps.setString(1, status);
				ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				int id = rs.getInt("RE_ID");
				r.setId(id);
				int amount = rs.getInt("RE_AMOUNT");
				r.setAmount(amount);
				String reason = rs.getString("RE_REASON");
				r.setReason(reason);
				String stat = rs.getString("RE_STATUS");
				r.setStatus(status);
				int completedBy = rs.getInt("RE_COMPLETEDBY");
				r.setCompletedBy(completedBy);
				int num = rs.getInt("RE_NUM");
				r.setNum(num);
				
				reimbursements.add(r);
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error, can not select from Reimbursements with status");
		}
		
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursementByIdAndStatus(int empId, String status) {
		List<Reimbursement> reimbursements = new ArrayList<>();


		String sql = "SELECT * FROM REIMBURSEMENTS R JOIN EMPLOYEES E ON R.RE_ID = E.EMP_ID WHERE R.RE_STATUS = ? AND R.RE_ID = ?";

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, status);
			ps.setInt(2, empId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				int id = rs.getInt("RE_ID");
				r.setId(id);
				int amount = rs.getShort("RE_AMOUNT");
				r.setAmount(amount);
				String reason = rs.getString("RE_REASON");
				r.setReason(reason);
				String stat = rs.getString("RE_STATUS");
				r.setStatus(status);
				int completedBy = rs.getInt("RE_COMPLETEDBY");
				r.setCompletedBy(completedBy);
				int num = rs.getInt("RE_NUM");
				r.setNum(num);
				
				reimbursements.add(r);
			}
					
				} catch (SQLException e) {
					System.out.println("Error. Can not select reimbursements");
				}
		
		return reimbursements;
	}

	// ---------------- DELETE REIMBURSEMENT -------------------
	@Override
	public void deleteReimbursement(int id) {
		String sql = "DELETE FROM REIMBURSEMENTS WHERE EMP_ID = ?";
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			
		} catch (SQLException e) {
			System.out.println("Error. Can not delete Reimbursement.");
		}
	}

	
	@Override
	public void updateReimbursement(int amount, String status, int num) {
			String sql = "UPDATE REIMBURSEMENTS" 
					+ " SET  "
					+ " RE_STATUS = ?"
					+ " WHERE RE_ID = ? AND RE_AMOUNT = ? ; COMMIT;";
			
			try (Connection con = ConnectionUtil.getHardCodedConnection();
					PreparedStatement ps = con.prepareStatement(sql)){
				
				ps.setString(1, status);
				ps.setInt(2, num);
				ps.setInt(3, amount);
				
				ps.execute();
				System.out.println("Reimbursement Updated");
				
				
			} catch (SQLException ex) {
				System.out.println("Error while updating. Please check parameters.");
			}
			
		}

		

}
