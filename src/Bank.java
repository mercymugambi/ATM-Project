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
	
	
	
	
	
	
	
	

}
