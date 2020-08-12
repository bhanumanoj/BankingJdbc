package com.cg.dao;




import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.beans.Account;
import com.cg.beans.Loan;
import com.cg.beans.Transaction;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class BankDao implements IBankDao{

	Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307?user=root&password=12345");
	

	public BankDao() throws SQLException,ClassNotFoundException {
		super();

		Class.forName("com.mysql.jdbc.Driver");
	}
		
	
	@Override
	public void deleteId(String accId1) throws SQLException {
		// TODO Auto-generated method stub
		
		
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("delete from test.Account where accountId = ?");
		preparedStatement.setString(1, accId1);
		int rows = preparedStatement.executeUpdate();
		System.out.println(rows+" row affected");
		
			
	}
	
	
	
	
	
	@Override
	public int deposit(String id3, int cash3) throws SQLException {
		
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("select depositAmount from test.Account where accountId = ?");
		
		preparedStatement.setString(1, id3);
		ResultSet rows = preparedStatement.executeQuery();
		rows.next();
		
		int cash = rows.getInt(1)+cash3;
		

		PreparedStatement preparedStatement1 = (PreparedStatement) conn.prepareStatement("update test.Account set depositAmount = ? where accountId = ?");
		preparedStatement1.setInt(1,cash);
		preparedStatement1.setString(2,id3);
		preparedStatement1.executeUpdate();
		

		return cash;

	}

	@Override
	public int withdraw(String id4, int cash4) throws SQLException {
		
		
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("select depositAmount from test.Account where accountId = ?");
		
		preparedStatement.setString(1,id4);
		ResultSet rows = preparedStatement.executeQuery();
		rows.next();
		
		int cash = rows.getInt(1)-cash4;
		
		
		PreparedStatement preparedStatement1 = (PreparedStatement) conn.prepareStatement("update test.Account set depositAmount = ? where accountId = ?");
		preparedStatement1.setInt(1,cash);
		preparedStatement1.setString(2,id4);
		preparedStatement1.executeUpdate();
		
		
		
		return cash;

	}

	@Override
	public Account AccountDetails(String id5) throws SQLException {
			
		
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("select accountId,accountName,address,depositAmount from test.Account where accountId = ?");
		preparedStatement.setString(1,id5);
		ResultSet rows = preparedStatement.executeQuery();
		rows.next();
		Account account =new Account();
		account.setAccountId(rows.getString(1));
		account.setAccountName(rows.getString(2));
		account.setAddress(rows.getString(3));
		account.setDepositAmount(rows.getInt(4));
		
		return account;
	}

	@Override
	public void create(Account account) throws SQLException {
		
		Transaction t = (Transaction) account;
		
																																			
		
		
		PreparedStatement preparedStatement= (PreparedStatement) conn.prepareStatement("insert into test.Account"+
				"(accountId,accountName,address,depositAmount,loanID,loanAmount,loanType)"+"values(?,?,?,?,?,?,?)");
		
		preparedStatement.setString(1, t.getAccountId());
		preparedStatement.setString(2, t.getAccountName());
		preparedStatement.setString(3, t.getAddress());
		preparedStatement.setInt(4, t.getDepositAmount());
		preparedStatement.setString(5, t.getLoanId());
		preparedStatement.setInt(6, t.getLoanAmount());
		preparedStatement.setString(7, t.getLoanType());
		
		
		int rows= preparedStatement.executeUpdate();
		System.out.println(rows+" row affected ");

	}

	@Override
	public int gLoan(String id7, int cash7) throws SQLException {
		
		
		PreparedStatement preparedStatement= (PreparedStatement) conn.prepareStatement("select loanAmount from test.Account where loanID = ?");
		preparedStatement.setString(1,id7);
		ResultSet rows = preparedStatement.executeQuery();
		rows.next();
		int balance = rows.getInt(1)+cash7;
		
		
		
		PreparedStatement preparedStatement1 = (PreparedStatement) conn.prepareStatement("update test.Account set loanAmount = ? where loanID = ?");
		preparedStatement1.setInt(1, balance);
		preparedStatement1.setString(2,id7);
		preparedStatement1.executeUpdate();
		
		return balance;

	}

	@Override
	public Loan LoanDetails(String id9) throws SQLException {
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("select loanID,loanAmount,loanType from test.Account where loanID = ?");
		preparedStatement.setString(1,id9);
		ResultSet rows = preparedStatement.executeQuery();
		rows.next();
		Loan loan = new Loan();
		loan.setLoanId(rows.getString(1));
		loan.setLoanAmount(rows.getInt(2));
		loan.setLoanType(rows.getString(3));
		
		return loan;
		
	}

	@Override
	public int pLoan(String id8, int cash8) throws SQLException {
		
		
		PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement("select loanAmount from test.Account where loanID = ?");
		preparedStatement.setString(1,id8);
		ResultSet rows = preparedStatement.executeQuery();
		rows.next();
		int bal = rows.getInt(1)-cash8;
		
		
		PreparedStatement preparedStatement1 = (PreparedStatement) conn.prepareStatement("update test.Account set loanAmount = ? where loanID = ?");
		preparedStatement1.setInt(1,bal);
		preparedStatement1.setString(2,id8);
		preparedStatement1.executeUpdate();
		
		return bal;
		
}

	
}