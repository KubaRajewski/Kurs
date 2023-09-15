package dalsze.podstawy.wielkie.liczby.system.bankowy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Account {
    private final Client client;
    private final BigDecimal number;
    private BigDecimal balance;
    private BigDecimal credit;
    private final static int NUMBER_OF_DIGITS_IN_ACCOUNT = 12;

    public static List<Account> extension = new ArrayList<>();

    public Account(Client client) {
        this.client = client;
        this.number = generateNewAccountNumber(NUMBER_OF_DIGITS_IN_ACCOUNT);
        this.balance = BigDecimal.ZERO;

        extension.add(this);
        client.getAccounts().add(this);
    }

    public static BigDecimal generateNewAccountNumber(int NUMBER_OF_DIGITS_IN_ACCOUNT) {
        Random rand = new Random();
        StringBuilder numberBuilder = new StringBuilder();
        numberBuilder.append(rand.nextInt(9) + 1);

        for (int i = 1; i < NUMBER_OF_DIGITS_IN_ACCOUNT; i++) {
            numberBuilder.append(rand.nextInt(10));
        }

        BigDecimal accountNumber = new BigDecimal(numberBuilder.toString());

        accountNumber = accountNumber.setScale(0, RoundingMode.DOWN);

        for (Account a : extension) {
            if(Objects.equals(a.getNumber(), accountNumber)) {
                return generateNewAccountNumber(NUMBER_OF_DIGITS_IN_ACCOUNT);
            }
        }

        return accountNumber;
    }

    public void transfer(BigDecimal accountNumber, BigDecimal amount) {
        Account account = extension.get(0);
        for (Account a : extension) {
            if (Objects.equals(a.getNumber(), accountNumber)) {
                account = a;
                break;
            }
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount is less than or equal to zero");
        }

        if (amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("amount is greater than balance");
        }

        withdraw(amount);
        account.deposit(amount);
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount is less than or equal to zero");
        }

        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount is less than or equal to zero");
        }

        if (amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("amount is greater than balance and credit");
        }

        credit = credit.subtract(amount);
    }



    public Client getClient() {
        return client;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public static List<Account> getExtension() {
        return extension;
    }

    @Override
    public String toString() {
        return number.toString() + ", balance: " + balance.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(number, account.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
