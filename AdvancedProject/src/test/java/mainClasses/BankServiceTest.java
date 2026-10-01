package mainClasses;

import org.junit.jupiter.api.Test;
import services.BankService;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {
    @Test
    void customerCanRegisterWithUniqueId() {
        BankService service = new BankService();
        Customer customer = service.registerCustomer("Test", "010000", "NEW1", "pass");
        assertEquals("NEW1", customer.getId());
        assertSame(customer, service.authenticateCustomer("NEW1", "pass"));
    }

    @Test
    void duplicateIdIsRejected() {
        BankService service = new BankService();
        assertThrows(IllegalArgumentException.class,
                () -> service.registerCustomer("Test", "010000", "C0", "pass"));
    }

    @Test
    void serviceCanCreateAndOperateAccount() {
        BankService service = new BankService();
        assertTrue(service.openNormalAccount("C0"));
        Customer customer = service.findCustomer("C0");
        assertNotNull(customer.getAccount());
        String accountId = customer.getAccount().getId();
        assertTrue(service.deposit(accountId, 100));
        assertTrue(service.withdraw(accountId, 50));
    }
}
