import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		// init Scanner
		Scanner sc = new Scanner(System.in);
		
		//init/create a bank
		Bank theBank = new Bank("Bank of Mercy");
		
		
		// add a user, which also creates a savings account
		User aUser = theBank.addUser("john", "Doe", "1234");
		
		//add a checking account for our user
		Account newAccount = new Account("Checking", aUser, theBank);
		aUser.addAccount(newAccount);   //add account to the user
		theBank.addAccount(newAccount); //add account to the bank

	}

}
