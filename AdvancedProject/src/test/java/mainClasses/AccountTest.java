package mainClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    void normalAccountDepositAddsCashback() {
        NormalAccount account = new NormalAccount("A1", 100);
        account.deposit(100);
        assertEquals(207, account.getBalance(), 0.0001);
    }

    @Test
    void normalAccountWithdrawAddsCashback() {
        NormalAccount account = new NormalAccount("A1", 200);
        assertTrue(account.withdraw(100));
        assertEquals(107, account.getBalance(), 0.0001);
    }

    @Test
    void investmentAccountRejectsOverdraft() {
        InvestmentAccount account = new InvestmentAccount("A2", 50);
        assertFalse(account.withdraw(60));
        assertEquals(50, account.getBalance(), 0.0001);
    }

    @Test
    void investmentAccountProjectsFivePercentIncrease() {
        InvestmentAccount account = new InvestmentAccount("A2", 1000);
        assertEquals(1050, account.getBalanceAfterIncrease(), 0.0001);
    }

    @Test
    void invalidAmountIsRejected() {
        NormalAccount account = new NormalAccount("A3", 100);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-5));
    }
}
