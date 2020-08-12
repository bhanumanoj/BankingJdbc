package com.cg.service;

import java.sql.SQLException;

import com.cg.beans.Account;
import com.cg.beans.Loan;
import com.cg.dao.BankDao;
import com.cg.dao.IBankDao;

public class BankService implements IBankService {
		
	IBankDao bankDao=new BankDao();
	
	
	public BankService() throws SQLException,ClassNotFoundException{
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean accountId(String id1) {
		String regexId = "^[0-9]{7}[A-Za-z]{4}$";
		return id1.matches(regexId);
	}

	@Override
	public boolean accountName(String name1) {
		String regexName = "^[A-Z]{1}[a-z]{2,30}$";
		return name1.matches(regexName);
	}

	@Override
	public int deposit(String id3, int cash3) throws SQLException {
		// TODO Auto-generated method stub
		return bankDao.deposit(id3, cash3);
	}

	@Override
	public int withdraw(String id4, int cash4) throws SQLException {
		// TODO Auto-generated method stub
		return bankDao.withdraw(id4, cash4);
	}

	@Override
	public Account AccountDetails(String id5) throws SQLException {
		return bankDao.AccountDetails(id5);
		
	}

	@Override
	public void create(Account account) throws SQLException {
		bankDao.create(account);
		
	}
	
	public int gLoan(String id7,int cash7) throws SQLException {
		return bankDao.gLoan(id7, cash7);
	}

	@Override
	public Loan LoanDetails(String id9) throws SQLException {
		return bankDao.LoanDetails(id9);
		
	}

	@Override
	public int pLoan(String id8, int cash8) throws SQLException {
		return bankDao.pLoan(id8, cash8);
	}

	@Override
	public void deleteId(String accId1) throws SQLException {
		// TODO Auto-generated method stub
		bankDao.deleteId(accId1);
	}
}
