package junit5;

public class Account {

    private String name;
    private String iban;
    private String code;
    private Money amount;

    public static class Validator {

        public static String iban(String iban) {
            if (iban == null || iban.isEmpty())
                throw new IllegalArgumentException("Iban can't be null or empty");
            else if (!iban.startsWith("LT"))
                throw new IllegalArgumentException("Only LT IBANs are supported");
            else if (iban.length() != 20)
                throw new IllegalArgumentException("Invalid IBAN length. Must be equal to 20 characters");

            return iban;
        }
    }

    public Account() {
    }

    public Account(String name, String iban, String code, Money amount) {
        this.name = name;
        this.iban = Validator.iban(iban);
        this.code = code;
        this.amount = amount;
    }

    public void reduce(Money money) {
        this.amount = Money.of(amount.amount().subtract(money.amount()));
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getIban() {
        return iban;
    }

    public Money getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", iban='" + iban + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
