package junit5;

import java.math.BigDecimal;

public class TransferMoney {

    /*
        Pre-transaction
        Validation
        1. + from.iban != to.iban
        2. + money != 0
        3. + money < 0;
        4. + from != null, to != null
        4. + from.getAmount() >= amount

        Post-transaction
        1. from.getAmount() = from.getAmount() - amount
        2. to.getAmount() = to.getAmount() + amount

     */
    public boolean send(Account from, Account to, Money amount) {

        validateAccountsNotNull(from, to);
        validateAccountsAreDifferent(from.getIban(), to.getIban());
        validateMoneyToSend(amount);
        validateAmounts(from.getAmount(), amount);
        reduceFrom(from, amount);
        addTo(to, amount);

        return true;
    }

    private void validateAccountsNotNull(Account from, Account to) {
        if (from == null & to != null)  {
            throw new IllegalArgumentException("Creditor account is not valid");
        } else if (to == null & from != null) {
            throw new IllegalArgumentException("Debtor account is not valid");
        } else if (from == null & to == null) {
            throw new IllegalArgumentException("Neither of transfer accounts are valid");


        }
    }

    private void validateMoneyToSend(Money amount) {
        if (amount.amount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Money to send not of positive amount");
        };
    }

    private void addTo(Account account, Money amount) {
        account.reduce(Money.of(amount.amount().negate()));
    }

    private static void reduceFrom(Account account, Money amount) {
        account.reduce(amount);
    }

    private void validateAmounts(Money from, Money amount) {
        if(from.amount().compareTo(amount.amount()) < 0)
            throw new IllegalArgumentException("Insufficient creditor amount");
    }

    private void validateAccountsAreDifferent(String from, String to) {
        if (from.equals(to))
            throw new IllegalArgumentException("Money can't be transferred between same accounts");
    }

}
