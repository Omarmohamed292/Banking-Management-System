package mainClasses;

public class Customer extends User {
    private Account account;
    private String password;

    public Customer(String name, String phoneNum, String id, String password) {
        super(name, phoneNum, id);
        setPassword(password);
    }

    public String getPassword() { return password; }
    public void setPassword(String password) {
        if (password == null || password.isBlank()) throw new IllegalArgumentException("Password cannot be blank");
        this.password = password;
    }

    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }

    @Override
    public String toString() {
        return "Customer{id='" + getId() + "', account=" + account + '}';
    }
}
