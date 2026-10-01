package mainClasses;

/** Standard account with the project's 7% transaction cashback rule. */
public class NormalAccount extends Account {
    private static final double CASHBACK = 0.07;

    public NormalAccount(String id, double balance) {
        super(id, balance);
    }

    @Override
    public boolean withdraw(double amount) {
        validateAmount(amount);
        if (getBalance() < amount) return false;
        setBalance(getBalance() - amount + amount * CASHBACK);
        new Transaction(true, amount, getId());
        return true;
    }

    @Override
    public void deposit(double amount) {
        validateAmount(amount);
        setBalance(getBalance() + amount + amount * CASHBACK);
        new Transaction(false, amount, getId());
    }

    @Override
    public String toString() {
        return "Normal: id=" + getId() + ", balance=" + getBalance() + '$';
    }
}
