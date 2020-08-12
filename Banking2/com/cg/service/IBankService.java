package com.cg.service;

import java.sql.SQLException;

import com.cg.beans.Account;
import com.cg.beans.Loan;

public interface IBankService {
		
	public boolean accountId(String id1);
	public boolean accountName(String name1);
	
	public int deposit(String id3,int cash3) throws SQLException;
	public int withdraw(String id4,int cash4) throws SQLException;
	public Account AccountDetails(String id5) throws SQLException;
	public void create(Account account) throws SQLException;
	
	public int gLoan(String id7,int cash7) throws SQLException;
	public int pLoan(String id8,int cash8) throws SQLException;
	public Loan LoanDetails(String id9) throws SQLException;
	public void deleteId(String accId1) throws SQLException;
	
}
