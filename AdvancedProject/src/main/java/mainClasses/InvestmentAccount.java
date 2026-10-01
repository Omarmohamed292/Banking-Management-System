package mainClasses;

/** Investment account with a projected 5% monthly increase. */
public class InvestmentAccount extends Account {
    private static final double INTEREST_RATE = 0.05;

    public InvestmentAccount(String id, double balance) {
        super(id, balance);
    }

    @Override
    public boolean withdraw(double amount) {
        validateAmount(amount);
        if (getBalance() < amount) return false;
        setBalance(getBalance() - amount);
        new Transaction(true, amount, getId());
        return true;
    }

    @Override
    public void deposit(double amount) {
        validateAmount(amount);
        setBalance(getBalance() + amount);
        new Transaction(false, amount, getId());
    }

    @Override
    public double getBalanceAfterIncrease() {
        return getBalance() * (1 + INTEREST_RATE);
    }

    @Override
    public String toString() {
        return "Investment: id=" + getId() + ", balance=" + getBalance() + '$';
    }
}
