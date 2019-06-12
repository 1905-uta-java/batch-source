package com.revature.pZero.dao;

import java.util.List;
import com.revature.pZero.model.BankAccount;

public interface BankAccountsDAO {
	
	public List<BankAccount> getAccounts(int user_Id);
	//public BankAccount getAccount(int account_id, String acct_Type);
	public int createBankAccount(BankAccount b);
	public int updateBankAccount(BankAccount b);
	public int deleteBankAccount(BankAccount b);
	public int getNextBankId(BankAccount b);
	
}
