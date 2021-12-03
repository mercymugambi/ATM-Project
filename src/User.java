import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
public class User {
	
	//What data should the user have?
	
	
	/**
	 * The first name of the user.
	 */
	private String firstName;
	/**
	 * The last name of the user.
	 */
	private String lastName;
	/**
	 * The id number of the user.
	 */
	private String uuid; //unique universal indentifier
	/**
	 * The MD5 of the user pin number.
	 */
	private byte pinHash[]; //we dont wanna store the actual pin value
	/**
	 * The list of accounts for this user.
	 */
	private ArrayList<Account> accounts;
	
	
	//creating the objects constructor
	
	/**
	 * create a new user
	 * @param firstName
	 * @param lastName		
	 * @param pin           the user account pin number
	 * @param theBank		the bank object which the user is a customer of
	 */
	
	public User(String firstName, String lastName, String pin, Bank theBank) {
		//set user name
		this.firstName = firstName;
		this.lastName = lastName;
		
		//store the pin's MD5 hash, rather than the original value, for 
		//security reasons
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			this.pinHash = md.digest(pin.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.err.println("error, caught NoSuchAlgorithmException");
			
			e.printStackTrace();
			System.exit(1);
		}
		//get a new unique universal ID for the user
		this.uuid = theBank.getNewUserUUID();
		
		//create empty list of accounts
		this.accounts = new ArrayList<Account>();
		
		//Print log message to know the uuid are like
		System.out.printf("New user%s, %s with ID %s created.\n",lastName,
				firstName, this.uuid);
		
	}
	/**
	 * add account for the user
	 * @param anAcct		the account to add
	 */
	
	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
	
	/**
	 * 
	 * @return the users uuid
	 * return the uuid
	 */
	public String getUUID() {
		return this.uuid;
	}
		
	/**
	 * Check whether a given pin matches the true user pin
	 * @param aPin the pin to check
	 * @return   whether the pin is valid or not
	 */
	public boolean validatePin(String aPin) {
	
			
		try {
			MessageDigest md = MessageDigest.getInstance("MDS");
			return MessageDigest.isEqual(md.digest(aPin.getBytes()),
					this.pinHash);
		} catch (NoSuchAlgorithmException e) {
			System.err.println("error, caught NoSuchAlgorithmException");
			e.printStackTrace();
			System.exit(1);
		
		}
		return false;
	
	
	
	

	}
}
