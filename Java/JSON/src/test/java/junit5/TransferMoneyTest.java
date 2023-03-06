package junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TransferMoneyTest {

    private TransferMoney transferMoney;

    @BeforeAll
    void initAll() {
        this.transferMoney = new TransferMoney();
    }

    @Test
    void testTransferMoneyIfNotZeroOrNegative() {
        Account debtor = new Account("A", "LT674589214475167546", "001", Money.of(100));
        Account creditor = new Account("B", "LT674589214475478623", "002", Money.of(50));

        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> transferMoney.send(creditor, debtor, Money.of(-5)));

        assertEquals("Money to send not of positive amount", exception.getMessage());

    }
    @Test
    void testIfTransferDebtorAccountIsInvalid() {
        Account debtor = null;
        Account creditor = new Account("B", "LT674589214475478623", "002", Money.of(50));

        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> transferMoney.send(creditor, debtor, Money.of(10)));

        assertEquals("Debtor account is not valid", exception.getMessage());

    }

    @Test
    void testIfTransferCreditorAccountIsInvalid() {
        Account debtor = new Account("A", "LT674589214475167546", "001", Money.of(100));
        Account creditor = null;

        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> transferMoney.send(creditor, debtor, Money.of(10)));

        assertEquals("Creditor account is not valid", exception.getMessage());

    }

    @Test
    void testIfNeitherTransferAccountsAreValid() {
        Account debtor = null;
        Account creditor = null;

        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> transferMoney.send(creditor, debtor, Money.of(10)));

        assertEquals("Neither of transfer accounts are valid", exception.getMessage());

    }


}