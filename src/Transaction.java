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
	
	/**
	 * create a new transaction
	 * @param amount the amount transacted
	 * @param inAccount the account the transaction belongs to
	 */
	public Transaction(double amount,Account inAccount) {
		this.amount = amount;
		this.inaccount = inAccount;
		this.timestamp = new Date();
		this.memo = "";
}
	public Transaction(double amount, String memo, Account inAccount) {
		//amount.call the two arg consructure first
		this(amount, inAccount);
		
		//set the memo
		this.memo = memo;
		
	}


}

