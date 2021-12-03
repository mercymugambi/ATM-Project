import java.util.ArrayList;
import java.util.Random;




public class Bank {
	
	/**
	 * What data should a bank have?
	 */
	
	/**
	 * The name of the bank
	 */
	private String name;
	
	/**
	 * List of User or bank customers
	 */
	private ArrayList<User> users;
	
	/**
	 *List of accounts users have 
	 */
	private ArrayList<Account> accounts;
	
	
	/**
	 * create a new bank object
	 * @param name of the bank
	 */
	public Bank(String name) {
		this.name = name;
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();
		
	}
	
	
	/**
	 * Generate a new universal unique id for user
	 * @return the UUID
	 */
	public String getNewUserUUID() {
		//init
		String uuid;
		Random rng = new Random();
		int len = 6;
		boolean nonUnique;
		
		
		//continue looping till we get an unique id
		do {
			
			//generate the number
			uuid="";
			for (int c=0; c< len; c++) {
				uuid +=((Integer)rng.nextInt(10)).toString();
			}
			
			//check to make sure its unique
			nonUnique = false;
			for (User u : this.users) {
				if (uuid.compareTo(u.getUUID()) == 0) {
					nonUnique = true;
					break;
				}
			}
		} while(nonUnique);
		
		
		return uuid;
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	
	public String getNewAccountUUID() {
		
			//init
			String uuid;
			Random rng = new Random();
			int len = 10;
			boolean nonUnique;
			
			
			//continue looping till we get an unique id
			do {
				
				//generate the number
				uuid="";
				for (int c=0; c< len; c++) {
					uuid +=((Integer)rng.nextInt(10)).toString();
				}
				
				
				//check to make sure its unique
				nonUnique = false;
				for (Account a : this.accounts) {
					if (uuid.compareTo(a.getUUID()) == 0) {
						nonUnique = true;
						break;
					}
				}
			} while(nonUnique);
			
			
			return uuid;
	}
	
	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
	
	public User addUser(String firstName, String lastName, String pin) {
		//create a user object add it to our list
		User newUser = new User(firstName, lastName, pin, this);
		this.users.add(newUser);
		
		//create a savings account for the user
		Account newAccount = new Account("Savings", newUser, this);
		newUser.addAccount(newAccount);
		this.addAccount(newAccount);
		
		return newUser;
	}
	
	/**
	 * Get the user object associated with a particular userID and pin, if they are
	 * valid 
	 * @param UserID   uuid of the user to login
	 * @param pin      the pin of the user
	 * @return         the user object, if the login is successful, or null, 
	 */
	public User userLogin(String UserID, String pin) {
		//Search through list of users
		for (User u : this.users) {
			
			
			//check user ID is correct
			if (u.getUUID().compareTo(UserID) == 0 && u.validatePin(pin)) {
				
				return u;
				
			}
			
		}
		
		//if user not found or has invalid pin
		return null;
	}
	
	}



	
	


