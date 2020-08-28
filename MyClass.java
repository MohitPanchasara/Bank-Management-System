import java.util.*;
import java.util.Random;

class BankAccount{
	private String username;
	private String password;
	private long Account;
	private long Balance;
	
	Random rand  = new Random();
	Scanner Sc = new Scanner(System.in);
	
	void AccountBalance(){
		int Pin = rand.nextInt(1000);
		long Bal;
		Account = Pin;
		System.out.println("--> Your Newly Generated Account Number Is: " + Account);
		System.out.print("--> Enter The Initial Amount to be Deposited in your Account: ");
		Bal = Sc.nextLong();
		System.out.println();
		if(Bal >= 100)
		{
			Balance = Bal;
		}else {
			System.out.println("The Inserted Amount is TOO LOW. Minimum Balance Must Be Rs. 100.00: ");
		}
	}
	
	void ShowAccount() {
		System.out.println("User Name: " + username);
		System.out.println("Account: "+ Account + "  Balance: Rs. " + Balance);
		System.out.println();
	}
	
	void SignUp(int i) {
		String K;
		if(i == 1)
			K = "st";
		else if(i == 2)
			K = "nd";
		else if(i == 3)
			K = "rd";
		else
			K = "th";
			
		System.out.print("> Enter " + i + K +" Account's Username: ");
		username = Sc.next();
		System.out.print("> Create Your NEW PASSWORD: ");
		password = Sc.next();
	}
	
	
	void Deposit() {
		long Bal;
		System.out.println("> ACCOUNT: " + username);
		System.out.print("> Enter the Amount (int Rs.) to be Deposited: ");
		Bal = Sc.nextLong();
		Balance = Balance + Bal;
		}
	
	void Withdrawl() {
		long Bal;
		System.out.println("> ACCOUNT: " + username);
		System.out.print("> Enter the Amount (in Rs.) to be Withdrawn: ");
		Bal = Sc.nextLong();
		if(Balance >= Bal) {
			Balance = Balance - Bal;
		}else {
			System.out.println("> Withdrawl failed... Insufficient Balance!! ");
			System.out.println();
		}	
	}
	
	boolean SeachUsername(String S) {
		if(S.equals(username)) {
			return (true);
		}
		return(false);
	}
	
	boolean SearchAcc(long S) {
		if(S == Account)
		{
			return(true);
		}
		return (false);
	}

}

public class MyClass {
    public static void main(String arg[]) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("###  WELCOME TO ONLINE BANK ### ");
        System.out.println("--------------------------------");
        System.out.println();
        System.out.println("How many New Accounts do you want to create?");
        System.out.print(">");
        
    	int n = Sc.nextInt();
    	BankAccount A[] = new BankAccount[n];
    	for (int i = 0; i < A.length; i++) {
        	A[i] = new BankAccount();
        	A[i].SignUp(i+1);
        	A[i].AccountBalance();
    	}
    	System.out.println("Welcome to Your New Bank Account/Accounts :-");
    	int s;
        do{
        	
        	System.out.println("1> DISPLAY ALL ");
        	System.out.println("2> WITHDRAW Money ");
        	System.out.println("3> DEPOSIT Monry ");
        	System.out.println("4> Search Account by Username ");
        	System.out.println("5> Search Account by Account Number ");
        	System.out.println("6> Exit:");
        	System.out.print("Enter Choice >");
        	s = Sc.nextInt();
        	System.out.println();
        	
        	switch (s) {
        		case 1:
        			for (int j = 0; j < A.length; j++) {
                        A[j].ShowAccount();
                    }
                    break;
                    
        		case 2:
        			boolean found = false;
        			System.out.print("Enter Account No : ");
        			long key = Sc.nextLong();
                    found = false;
                    for (int j = 0; j < A.length; j++) {
                        found = A[j].SearchAcc(key);
                        if (found) {
                            A[j].Withdrawl();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed... Account Does Not Exist!");
                        System.out.println();
                    }
                    break;
        		case 3:
        			System.out.print("Enter Account No : ");
                    key = Sc.nextLong();
                    found = false;
                    for (int j = 0; j < A.length; j++) {
                        found = A[j].SearchAcc(key);
                        if (found) {
                            A[j].Deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed... Account Does Not Exist!");
                        System.out.println();
                    }
                    break;
        		case 4:
        			System.out.print("Enter Account Name You Want to Search: ");
                    String S = Sc.next();
                    System.out.println("Search results:-");
                    
                    found = false;
                    for (int j = 0; j < A.length; j++) {
                        found = A[j].SeachUsername(S);
                        if (found) {
                        	A[j].ShowAccount();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                        System.out.println();
                    }
                    break;
        		case 5:
        			System.out.print("Enter Account Number You Want to Search: ");
        			key = Sc.nextLong();
        			System.out.println("Search results:-");      			
                    
                    found = false;
                    for (int j = 0; j < A.length; j++) {
                        found = A[j].SearchAcc(key);
                        if (found) {
                        	A[j].ShowAccount();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed... Account Does Not Exist!");
                        System.out.println();
                    }
                    break;
        			
        		case 6:
                    System.out.println("That was a pleasure working. Have a nice day!!");
                    break;
        	}
        }while(s != 6);
        	
    }
}
