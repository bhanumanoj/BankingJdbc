package com.cg.dao;

import java.sql.SQLException;

import com.cg.beans.Account;
import com.cg.beans.Loan;

public interface IBankDao {
	
	public void deleteId(String accId1) throws SQLException;
	public int deposit(String id3,int cash3) throws SQLException;
	public int withdraw(String id4,int cash4) throws SQLException;
	public Account AccountDetails(String id5) throws SQLException;
	public void create(Account account) throws SQLException;
	
	public int gLoan(String id7,int cash7) throws SQLException;
	public int pLoan(String id8,int cash8) throws SQLException;
	public Loan LoanDetails(String id9) throws SQLException;
	
	
	
	
}
