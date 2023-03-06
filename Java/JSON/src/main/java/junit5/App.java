package junit5;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {

        Account debtor = new Account(
                "Mindaugas L",
                "LT113318857872554695",
                "001",
                new Money(BigDecimal.valueOf(10))
        );

        Account creditor = new Account(
                "Monika J",
                "LT174481512647558377",
                "002",
                new Money(BigDecimal.valueOf(100))
        );

        TransferMoney transferMoney = new TransferMoney();
        boolean success = transferMoney.send(creditor, debtor, new Money(BigDecimal.valueOf(20)));

        System.out.println("Money sent?: " + success);
    }
}
