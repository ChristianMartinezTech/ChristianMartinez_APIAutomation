package util.users;

/***
 * POJO Bank User class
 */
public class BankUser {
    private String Name;
    private String LastName;
    private int AccountNumber;
    private double Amount;
    private String TransactionType;
    private String Email;
    private boolean Active;
    private String Country;
    private String Telephone;

    /***
     * Bank User Constructor
     * @param name User name
     * @param lastName User last name
     * @param accountNumber User Account number
     * @param amount User amount
     * @param transactionType User transaction type
     * @param email User email
     * @param active Is the user active?
     * @param country User country
     * @param telephone User telephone
     */
    public BankUser(String name, String lastName, int accountNumber,
                    double amount, String transactionType, String email,
                    boolean active, String country, String telephone){
        this.Name = name;
        this.LastName = lastName;
        this.AccountNumber = accountNumber;
        this.Amount = amount;
        this.TransactionType = transactionType;
        this.Email = email;
        this.Active = active;
        this.Country = country;
        this.Telephone = telephone;
    }

    // Getter Methods
    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public double getAmount() {
        return Amount;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public String getEmail() {
        return Email;
    }

    public boolean getActive(){
        return Active;
    }

    public String getCountry() {
        return Country;
    }

    public String getTelephone() {
        return Telephone;
    }


    // Setter Methods
    public void setName(String name) {
        Name = name;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }
}
