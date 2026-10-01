package mainClasses;

public class Employee extends User {
    private String password;

    public Employee(String name, String phone, String id, String password) {
        super(name, phone, id);
        setPassword(password);
    }

    public String getPassword() { return password; }
    public void setPassword(String password) {
        if (password == null || password.isBlank()) throw new IllegalArgumentException("Password cannot be blank");
        this.password = password;
    }

    public void openInvestmentAccount(Customer customer, String id, double balance) {
        customer.setAccount(new InvestmentAccount(id, balance));
    }

    public void openNormalAccount(Customer customer, String id, double balance) {
        customer.setAccount(new NormalAccount(id, balance));
    }

    public void closeAccount(Customer customer) { customer.setAccount(null); }

    public boolean createTransaction(Account account, boolean isWithdraw, double amount) {
        if (isWithdraw) return account.withdraw(amount);
        account.deposit(amount);
        return true;
    }
}
