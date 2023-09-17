package dalsze.podstawy.wielkie.liczby.system.bankowy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Account {
    private final static int NUMBER_OF_DIGITS_IN_ACCOUNT = 12;
    private final static double STANDARD_INTEREST_RATE = 0.05;
    private final static double PREMIUM_INTEREST_RATE = 0.1;
    public static List<Account> extension = new ArrayList<>();
    private final Client client;
    private final BigDecimal number;
    private BigDecimal balance;
    private BigDecimal credit;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(Client client, BigDecimal credit) {
        this.client = client;
        this.number = generateNewAccountNumber(NUMBER_OF_DIGITS_IN_ACCOUNT);
        this.balance = BigDecimal.ZERO;
        this.credit = credit;

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
            if (Objects.equals(a.getNumber(), accountNumber)) {
                return generateNewAccountNumber(NUMBER_OF_DIGITS_IN_ACCOUNT);
            }
        }

        return accountNumber;
    }

    public static void checkForInterest() {
        for (Account account : extension) {
            if (account.balance.compareTo(BigDecimal.ZERO) < 0) {
                account.payInterest(BigDecimal.valueOf(STANDARD_INTEREST_RATE));
            }
        }
    }

    public static void taxTheRich() {
        for (Account account : extension) {
            if (account.balance.compareTo(BigDecimal.valueOf(1000000)) >= 0) {
                account.transactions.add(new Transaction(account, null, TransactionType.TAX, account.balance.multiply(BigDecimal.valueOf(PREMIUM_INTEREST_RATE))));
                account.balance = account.balance.subtract(account.balance.multiply(BigDecimal.valueOf(PREMIUM_INTEREST_RATE)));
            }
        }
    }

    public static Account findAccountWithTheMostMoney(List<Account> accounts) {
        Account richestAccount = accounts.get(0);
        for (Account account : accounts) {
            if (account.getBalance().compareTo(richestAccount.getBalance()) > 0) {
                richestAccount = account;
            }
        }
        return richestAccount;
    }

    public static Account accountWithMostTransactions(List<Account> extension) {
        Account account = extension.get(0);
        for (Account a : extension) {
            if (a.getTransactions().size() > account.getTransactions().size()) {
                account = a;
            }
        }
        return account;
    }

    public static List<Account> accountsWithDebt(List<Account> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("list is empty");
        }

        List<Account> accountsWithDebt = new ArrayList<>();
        for (Account a : list) {
            if (a.getBalance().compareTo(BigDecimal.ZERO) < 0) {
                accountsWithDebt.add(a);
            }
        }
        return accountsWithDebt;
    }

    public static List<Account> getExtension() {
        return extension;
    }

    public void transfer(Account targetAccount, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount is less than or equal to zero");
        }

        if (amount.compareTo(balance) > 0) {
            BigDecimal deficit = amount.subtract(balance);

            if (deficit.compareTo(credit) > 0) {
                throw new IllegalArgumentException("Amount is greater than balance and credit");
            }

            balance = BigDecimal.ZERO;
            credit = credit.subtract(deficit);
        } else {
            balance = balance.subtract(amount);
        }

        transactions.add(new Transaction(this, targetAccount, TransactionType.TRANSFER, amount));

        targetAccount.balance = targetAccount.balance.add(amount);
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount is less than or equal to zero");
        }

        transactions.add(new Transaction(this, null, TransactionType.DEPOSIT, amount));
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount is less than or equal to zero");
        }

        if (amount.compareTo(balance) > 0) {
            System.out.println("amount is greater than balance");
            if (amount.compareTo(balance.add(credit)) > 0) {
                throw new IllegalArgumentException("amount is greater than balance and credit");
            } else {
                System.out.println("credit used");

                transactions.add(new Transaction(this, null, TransactionType.DEPOSIT, amount));
                credit = balance.add(credit).subtract(amount);
                balance = balance.subtract(amount);
            }
        } else {
            transactions.add(new Transaction(this, null, TransactionType.DEPOSIT, amount));
            balance = balance.subtract(amount);
        }
    }

    public void payInterest(BigDecimal interest) {
        if (interest.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("interest is less than or equal to zero");
        }

        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            transactions.add(new Transaction(this, null, TransactionType.TAX, balance.multiply(interest)));
            credit = credit.add(balance.multiply(interest));
            balance = balance.add(balance.multiply(interest));
        }
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

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
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
