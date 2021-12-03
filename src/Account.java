import java.util.ArrayList;
public class Account {
	
	//what makes sense for the user to have an account?
	
	/**
	 * The name of the account.
	 */
	private String name; //savings, fixed etc.
	
	
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
	/**
	 * Create  a new account
	 * @param name		name of the account
	 * @param holder	user object that holds this account
	 * @param theBank	bank that issues the account
	 */
	
	public Account(String name, User holder, Bank theBank) {
		
		//set the accoutn name and holder
		this.name = name;
		this.holder = holder;
		
		//get new account uuid
		this.uuid = theBank.getNewAccountUUID();
		
		//init transactions
		this.transactions = new ArrayList<Transaction>();
		
		
	}
	
	public String getUUID() {
		return this.uuid;
	}

}
