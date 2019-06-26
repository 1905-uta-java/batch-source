package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.daos.ReimburseDao;
import com.revature.daos.ReimburseDaoImpl;
import com.revature.models.Reimburse;

public class ReimburseService {
	ReimburseDao remDao = new ReimburseDaoImpl();
	ArrayList<Reimburse> remList = new ArrayList<>();
	ArrayList<Reimburse> remUserList = new ArrayList<>();
	ArrayList<Reimburse> remChangeList = new ArrayList<>();
	ArrayList<Reimburse> remNewList = new ArrayList<>();
	ArrayList<Reimburse> remAdminList = new ArrayList<>();
	Reimburse r = null;
	
	public ReimburseService(){
		remList = getAll();
	}
	
	public ArrayList<Reimburse> getAll(){
		return remDao.getAllReimburseReq();
	}
	
	public ArrayList<Reimburse> getRemsFromId(int id){
		
		if(remUserList != null) 
			remUserList.clear();	
		else {
			remUserList = new ArrayList();
		}
		
		System.out.println("Looking for Reimbursment Requests from User with ID: " + id);
		if(remList != null) {
			for(int i = 0; i < remList.size(); i++) {
				System.out.println(remList.get(i));
				if(remList.get(i).getEmpId() == id) {
					if(remUserList.indexOf(remList.get(i)) == -1) {
						remUserList.add(remList.get(i));
					} else {
						System.out.println("UHOH FOUND SOMETHING AT " + i + " whatever it is, it exists");
					}

				}
			}
		}
		
		return remUserList;
	}
	
	public Reimburse getSingleRem(int id) {
		Reimburse r = null;
		for(int i = 0; i < remList.size();i++) {
			if(remList.get(i).getRem_id()== id) {
				r = remList.get(i);
			}
		}
		
		return r;
	}
	
	public void addReimbursement(Reimburse r) {
		System.out.println("Adding " + r + " do remlist");
		remUserList.add(r);
		remList.add(r);
		remNewList.add(r); 
		System.out.println("New remlist is " + remUserList);
	}
	
	
	public List<Reimburse> getAllRemsWithStatus(String status){
		ArrayList<Reimburse> remsWithStatus = new ArrayList<>();
		if(remList != null) {
			for(int i = 0; i < remList.size(); i++) {
				System.out.println(remList.get(i));
				if(remList.get(i).getStatus().equals(status)) {
					remsWithStatus.add(remList.get(i));
				}
			}
		}
		
		return remsWithStatus;
	}
	

	public List<Reimburse> getRemsWithStatus(String status, int id){
		ArrayList<Reimburse> remsStatusId = new ArrayList<>();
		if(remList != null) {
			for(int i = 0; i < remUserList.size(); i++) {
				System.out.println(remUserList.get(i));
				if(remUserList.get(i).getStatus().equals(status) &&
						remUserList.get(i).getEmpId()== id) {
					remsStatusId.add(remUserList.get(i));
				}
			}
		}
		
		return remsStatusId;
	}
	
	public void updateReimburse(Reimburse r) {
		for(int i = 0; i < remChangeList.size(); i++) {
			if(remChangeList.get(i).getRem_id() == r.getRem_id()) {
				remChangeList.set(i, r);
			}
		}
	}
	
	public int getNewRemNum() {
		int maxId = 0;
		for(int i = 0; i < remList.size(); i++) {
			if (remList.get(i).getRem_id() > maxId){
				maxId = remList.get(i).getRem_id();
			}
		}
		
		return ++maxId;
	}
	
	public ArrayList<Reimburse> upd(){
		return remUserList;
	}
	
	public void forceDB() {
		//insert
		if(remNewList != null) {
			for(int i = 0; i < remNewList.size(); i++) {
				remDao.newReimburse(remNewList.get(i));
			}			
		}
		
		//update
		System.out.println("CHANGE reimburse list size: " + remChangeList.size());
		if(remChangeList != null) {
			for(int i = 0; i < remChangeList.size(); i++) {
				remDao.updateReimburse(remChangeList.get(i));
			}			
		}
	}

	public void logout() {
		remUserList.clear();
		remChangeList.clear();
		remNewList.clear();
		remAdminList.clear();
	}

	public void approve(int id) {
		boolean found = false;
		Reimburse r = getSingleRem(id);
		r.setStatus("Accepted");
		
		//check to make sure it doesn't already exist
		for(int i = 0; i < remAdminList.size(); i++) {
			if(r.getRem_id() == remAdminList.get(i).getRem_id()) {
				found = true;
				remAdminList.set(i, r);
			}
		}
		if(found)
			remChangeList.add(r);
				
	}

	public void deny(int id) {
		boolean found = false;
		
		Reimburse r = getSingleRem(id);
		r.setStatus("Rejected");
		for(int i = 0; i < remAdminList.size(); i++) {
			if(r.getRem_id() == remAdminList.get(i).getRem_id()) {
				found = true;
				remAdminList.set(i, r);
			}
		}
		if(found)
			remChangeList.add(r);

	}

	public ArrayList<Reimburse> getRemsForAdmin(int id) {
		remAdminList = remDao.getAllWithManId(id);
		
		return remAdminList;
	}
	
}
