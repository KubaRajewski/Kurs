package dalsze.podstawy.wielkie.liczby.system.bankowy;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private final TransactionType transactionType;
    private final Account sourceAccount;
    private final Account targetAccount;
    private final BigDecimal amount;
    private final LocalDateTime date;

    public Transaction(Account sourceAccount,Account targetAccount, TransactionType transactionType, BigDecimal amount) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Account getTargetAccount() {
        return targetAccount;
    }
}
