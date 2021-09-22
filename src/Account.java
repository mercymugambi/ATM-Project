import java.util.ArrayList;
public class Account {
	
	//what makes sense for the user to have an account?
	
	/**
	 * The name of the account.
	 */
	private String name; //savings, fixed etc.
	
	/**
	 * The current balance of the account
	 */
	private double balance;
	
	/**
	 * The account Id.
	 */
	
	private String uuid; //different from users
	
	/**
	 * The User object that owns this Account
	 */
	private User holder; //Some user owns this account and to be linked to the particular user
	
	/**
	 * The list of Transactions for this Account
	 */
	private ArrayList<Transaction> transactions;
	

}
