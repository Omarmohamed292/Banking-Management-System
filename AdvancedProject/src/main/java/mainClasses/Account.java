package mainClasses;

/** Base class for all bank account types. */
public abstract class Account {
    private String id;
    private double balance;

    protected Account(String id, double balance) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Account ID cannot be blank");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.id = id;
        this.balance = balance;
    }

    public String getId() { return id; }
    public void setId(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Account ID cannot be blank");
        this.id = id;
    }

    public double getBalance() { return balance; }
    public void setBalance(double balance) {
        if (balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
        this.balance = balance;
    }

    /** Approximate EGP conversion used by the original project UI. */
    public double getBalanceEG() { return balance * 47; }

    public double getBalanceAfterIncrease() { return balance * 1.05; }

    public abstract boolean withdraw(double amount);
    public abstract void deposit(double amount);

    protected void validateAmount(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }
}
