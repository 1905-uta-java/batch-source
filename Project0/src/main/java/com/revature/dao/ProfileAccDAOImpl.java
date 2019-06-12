package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.AccountInfo;
import com.revature.model.ProfileAcc;
import com.revature.util.ConnectionUtil;

public class ProfileAccDAOImpl implements ProfileAccDAO{

	@Override
	public ProfileAcc getProfile(int id) {
		String sql = "SELECT * FROM PROFILEACC WHERE P_ID = ?";
		ProfileAcc prof = null;
		
		try(Connection conMan = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = conMan.prepareStatement(sql)){
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int pId = rs.getInt("P_ID");
				String fullName = rs.getString("FULL_NAME");
				String email = rs.getString("EMAIL");
				String address = rs.getString("ADDRESS");
				String city = rs.getString("CITY");
				String state = rs.getString("STATE");
				String country = rs.getString("COUNTRY");
				int zip = rs.getInt("ZIP_CODE");
				int aId = rs.getInt("ACCOUNT_ID");
				AccountInfo accInfo = new AccountInfo(aId, 0, address, city, state, country, zip);
				prof = new ProfileAcc(pId, fullName, email, address, accInfo, city, state, country, zip);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prof;
	}

	@Override
	public List<String> getEmails() {
		String sql = "SELECT EMAIL FROM PROFILEACC";
		List<String> emails = new ArrayList<>();
		
		try (Connection conMan = ConnectionUtil.getHardCodedConnection();
				Statement s = conMan.createStatement();
				ResultSet rs = s.executeQuery(sql)){
			
			while(rs.next()) {
				String currEmail = rs.getString("EMAIL");
				emails.add(currEmail);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emails;
	}

	//might not need this method since a stored procedure will always create a profile
	//redacted as it is functionally useless, 1 profile per user
	@Override
	public boolean createProfile() {
		// TODO Auto-generated method stub
		return false;
	}

}
