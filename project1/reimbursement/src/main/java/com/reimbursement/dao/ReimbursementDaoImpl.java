package com.reimbursement.dao;

import com.reimbursement.model.Reimbursement;
import com.reimbursement.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public int makeRequest(Reimbursement r) {
		int isCreated = 0;
		String query = "INSERT INTO REIMBURSEMENT VALUES(?, ?, ?, ?, ?)";

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, r.getEmployeeId());
			ps.setInt(2, r.getSupervisorId());
			ps.setString(3, r.getTitle());
			ps.setDouble(4, r.getAmount());
			ps.setString(5, r.getStatus());
			isCreated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isCreated;
	}

	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> r = new ArrayList<>();
		String query = "SELECT * FROM REIMBURSEMENT";

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(query);) {

			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setId(rs.getInt("ID"));
				reimbursement.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				reimbursement.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				reimbursement.setTitle(rs.getString("TITLE"));
				reimbursement.setSubmissionDate(rs.getDate("DATE"));
				reimbursement.setAmount(rs.getDouble("AMOUNT"));
				r.add(reimbursement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		Reimbursement r = new Reimbursement();
		String query = "SELECT * FROM REIMBURSEMENT WHERE ID = ?";

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				r.setId(rs.getInt("ID"));
				r.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				r.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				r.setTitle(rs.getString("TITLE"));
				r.setSubmissionDate(rs.getDate("DATE"));
				r.setAmount(rs.getDouble("AMOUNT"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<Reimbursement> getUnsolvedReimbursements() {
		List<Reimbursement> r = new ArrayList<>();
		String pending = "P";
		String query = "SELECT * FROM REIMBURSEMENT WHERE STATUS = " + pending;

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(query);) {

			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setId(rs.getInt("ID"));
				reimbursement.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				reimbursement.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				reimbursement.setTitle(rs.getString("TITLE"));
				reimbursement.setSubmissionDate(rs.getDate("DATE"));
				reimbursement.setAmount(rs.getDouble("AMOUNT"));
				r.add(reimbursement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<Reimbursement> getUnsolvedReimbursementsByEmployeeId(int id) {
		List<Reimbursement> r = new ArrayList<>();
		String pending = "P";
		String query = "SELECT * FROM REIMBURSEMENT WHERE STATUS = " + pending + " AND EMPLOYEE_ID = ?";

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(query);) {

			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setId(rs.getInt("ID"));
				reimbursement.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				reimbursement.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				reimbursement.setTitle(rs.getString("TITLE"));
				reimbursement.setSubmissionDate(rs.getDate("DATE"));
				reimbursement.setAmount(rs.getDouble("AMOUNT"));
				r.add(reimbursement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<Reimbursement> getSolvedReimbursements() {
		List<Reimbursement> r = new ArrayList<>();
		String approved = "A";
		String rejected = "R";
		String query = "SELECT * FROM REIMBURSEMENT WHERE STATUS = " + approved + " OR STATUS = " + rejected;

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(query);) {

			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setId(rs.getInt("ID"));
				reimbursement.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				reimbursement.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				reimbursement.setTitle(rs.getString("TITLE"));
				reimbursement.setSubmissionDate(rs.getDate("DATE"));
				reimbursement.setAmount(rs.getDouble("AMOUNT"));
				r.add(reimbursement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<Reimbursement> getSolvedReimbursementsByEmployeeId(int employee_id) {
		List<Reimbursement> r = new ArrayList<>();
		String approved = "A";
		String rejected = "R";
		String query = "SELECT * FROM REIMBURSEMENT WHERE STATUS = " + approved + " OR STATUS = " + rejected
				+ " AND EMPLOYEE_ID = ?";

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(query);) {

			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setId(rs.getInt("ID"));
				reimbursement.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				reimbursement.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				reimbursement.setTitle(rs.getString("TITLE"));
				reimbursement.setSubmissionDate(rs.getDate("DATE"));
				reimbursement.setAmount(rs.getDouble("AMOUNT"));
				r.add(reimbursement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public int approveRequest(int id) {
		int approvesUpdated = 0;
		String approved = "A";
		String query = "UPDATE REIMBURSEMENT SET STATUS = " + approved + " WHERE ID = ?";

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			// con.setAutoCommit(false);
			ps.setInt(1, id);
			approvesUpdated = ps.executeUpdate();
			// con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return approvesUpdated;
	}

	@Override
	public int rejectRequest(int id) {
		int rejectsUpdated = 0;
		String rejected = "R";
		String query = "UPDATE REIMBURSEMENT SET STATUS = " + rejected + " WHERE ID = ?";

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(query)) {
			// con.setAutoCommit(false);
			ps.setInt(1, id);
			rejectsUpdated = ps.executeUpdate();
			// con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rejectsUpdated;
	}

	@Override
	public List<Reimbursement> getReimbursementsByEmployeeId(int id) {
		List<Reimbursement> r = new ArrayList<>();
		String query = "SELECT * FROM REIMBURSEMENT WHERE EMPLOYEE_ID = ?";

		try (Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(query);) {

			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setId(rs.getInt("ID"));
				reimbursement.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				reimbursement.setSupervisorId(rs.getInt("SUPERVISOR_ID"));
				reimbursement.setTitle(rs.getString("TITLE"));
				reimbursement.setSubmissionDate(rs.getDate("DATE"));
				reimbursement.setAmount(rs.getDouble("AMOUNT"));
				r.add(reimbursement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
}
