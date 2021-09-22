
import java.util.Date;
public class Transaction {
	
	/**
	 * What kind of data would you want for each transactions
	 */
	
	/**
	 * The amount of this transaction
	 */

	private double amount;
	
	/**
	 * The time and date for this transaction
	 */
	private Date timestamp;
	
	/**
	 * A memo for this transaction
	 */
	private String memo;
	
	/**
	 * The account in which the transaction was performed
	 */
	private Account inaccount;
}
