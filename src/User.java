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

}
