package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimburse;

public interface ReimburseDao {
	public ArrayList<Reimburse> getAllReimburseReq();
	public ArrayList<Reimburse> getReimburseForUser(int id);
	public int newReimburse(Reimburse r);
	public int updateReimburse(Reimburse r);
	public int delReimburse(int rId);
	public List<Reimburse> getAllWithStatus(String status);
	public List<Reimburse> getWithStatus(String status, int id);
	int newRemId();
	public ArrayList<Reimburse> getAllWithManId(int id);
	
}
