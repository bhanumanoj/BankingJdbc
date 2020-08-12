package com.cg.ui;




import java.sql.SQLException;
import java.util.Scanner;

import com.cg.beans.Account;
import com.cg.beans.Loan;
import com.cg.beans.Transaction;
import com.cg.service.BankService;
import com.cg.service.IBankService;

public class Customer {
	
	static Scanner scan=new Scanner(System.in);
	
	
	public static void main(String[] args) throws SQLException,ClassNotFoundException {
			
		Transaction transaction =null;
		
		IBankService service = null;
		
		service = new BankService();
		
		while(true)
		{
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("select a option and press enter");
			System.out.println("_______________________________");
			System.out.println("1.Create Account");
			System.out.println("2.Delete Account");
			System.out.println("3.Deposit");
			System.out.println("4.WithDraw");
			System.out.println("5.AccountDetails");
			System.out.println("6.GetLoan");
			System.out.println("7.PayLoan");
			System.out.println("8.Loan Details");
			System.out.println("9.Exit");
			System.out.println("_______________________________");
			
			switch(scan.nextInt()) {
			case 1 :
					transaction = new Transaction();
					while(true) {
					System.out.println("Enter account Id");
					String Id = scan.next();
					if(service.accountId(Id)) {	
						transaction.setAccountId(Id);
						break;
						}else {
							System.out.println("account Number is not in valid format");
							return;
						}
					}
					while(true) {
						System.out.println("Enter name");
						String uname = scan.next();
						if(service.accountName(uname)) {
							transaction.setAccountName(uname);
							break;
						}else {
							System.out.println("Name is not in valid format");
							return;	
						}
					}		
					System.out.println("Enter address");
					String address= scan.next();
					
					transaction.setAddress(address);
					
					System.out.println("Enter deposit amount");
					transaction.setDepositAmount(scan.nextInt());
					
					System.out.println("Need Loan");
					System.out.println("1 for Yes \n 2 for No :");
					int ch = scan.nextInt();
					if(ch==1) {
						System.out.println("Enter loanId");
						transaction.setLoanId(scan.next());
						
						System.out.println(" Home\n Car \n Education");
						
						transaction.setLoanType(scan.next());
						
						System.out.println("Enter loan amount");
						transaction.setLoanAmount(scan.nextInt());
						
						
					}
					System.out.println("Account is created");
					service.create(transaction);
					break;
		
					
			case 2: 
				System.out.println("Enter account id");
				String Id2=scan.next();
				service.deleteId(Id2);
				System.out.println("deleted");
				break;
			
					
			case 3:
				System.out.println("Enter accountId :");
				String Id3 = scan.next();
				System.out.println("Enter amount :");
				int cash3 = scan.nextInt();
				int bal=service.deposit(Id3, cash3);
				System.out.println("New balance :"+bal);
				break;
				
		case 4:
				System.out.println("Enter accountId :");
				String Id4 = scan.next();
				System.out.println("Enter amount :");
				int cash4 = scan.nextInt();
				int bal4=service.withdraw(Id4, cash4);
				System.out.println("New balance :"+bal4);
				break;
		
				
		case 5:
			System.out.println("Enter AccountId :");
			String Id5 = scan.next();
			Account Id6 = service.AccountDetails(Id5);
			if(Id6!=null) {
				System.out.println(Id6);
				break;
			}else {
				System.out.println("Not found");
				break;
			}
			
	case 6:
			System.out.println("Enter amount of loan: ");
			int cash6 = scan.nextInt();
			System.out.println("Enter loanId : ");
			String Id06 = scan.next();
			int bal6 = service.gLoan(Id06, cash6);
			System.out.println(bal6+" loan amount got");
			break;
	
	case 7:
			System.out.println("Enter amount : ");
			int cash7 = scan.nextInt();
			System.out.println("Enter loanId : ");
			String Id7 = scan.next();
			int bal7 = service.pLoan(Id7, cash7);
			System.out.println("paid loan amount "+bal7);
			break;
			
	case 8:
			System.out.println("Enter loanId : ");
			String Id8 = scan.next();
			Loan loan = service.LoanDetails(Id8);
			if(loan!=null)
				System.out.println("Loan Id ="+loan.getLoanId()+" Loan type = "+loan.getLoanType()+" Loan Amount = "+loan.getLoanAmount());
			else
				System.out.println("loanId not matched");
			
			break;
			
	case 9:
			System.out.println("Thank you!");break;
			
			
			
	}
}


}
}