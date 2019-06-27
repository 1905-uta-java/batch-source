package com.revature.dao;

import java.util.List;

import com.revature.models.Bear;

public interface BearDao {
	
	public List<Bear> getBears();
	public Bear getBearById(int id);
	public int createBear(Bear b);
	public void updateBear(Bear b);
	public void deleteBearById(int bearId);

}
