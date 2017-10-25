/**
 * Class implementing a bank account.
 * <p>
 * Complete and document this class as part of Lab 8.
 *
 * @see <a href="https://cs125.cs.illinois.edu/lab/8/">Lab 8 Description</a>
 */
public class BankAccount {

    /**
     * You may want to use this to distinguish between different kinds of accounts.
     */
    public enum BankAccountType {
        /**  **/
        CHECKINGS,

        /**  **/
        SAVINGS,

        /**  **/
        STUDENT,

        /**  **/
        WORKPLACE
    }

    /**  **/
    private int accountNumber;

    /**  **/
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public BankAccountType accountType;

    /**  **/
    private double accountBalance;

    /**  **/
    private String ownerName;

    /**  **/
    @SuppressWarnings("checkstyle:visibilitymodifier")
    public double interestRate;

    /**  **/
    private double interestEarned;

    /**
     * @param name name
     * @param accountCategory account category
     */
    public BankAccount(final String name, final BankAccountType accountCategory) {
        /*
         * Implement this function
         */
        this.setOwnerName(name);
        this.accountType = accountCategory;
        Bank.totalAccounts++;
    }

    /*
     * Implement getters and setters as appropriate for private variables.
     */

    /**
     * @return acc #
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param newAccountNumber new account Number
     */
    public void setAccountNumber(final int newAccountNumber) {
        this.accountNumber = newAccountNumber;
    }

    /**
     * @return account balance
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * @param newAccountBalance new account balance
     */
    public void setAccountBalance(final double newAccountBalance) {
        this.accountBalance = newAccountBalance;
    }

    /**
     * @return owner Name
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * @param newOwnerName new name
     */
    public void setOwnerName(final String newOwnerName) {
        this.ownerName = newOwnerName;
    }

    /**
     * @return interest earned
     */
    public double getInterestEarned() {
        return interestEarned;
    }

    /**
     * @param newInterestEarned new interest earned
     */
    public void setInterestEarned(final double newInterestEarned) {
        this.interestEarned = newInterestEarned;
    }
}
