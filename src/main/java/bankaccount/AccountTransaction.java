package bankaccount;

import java.time.LocalDateTime;

public class AccountTransaction {
    private final TransactionType type;
    private final int value;
    private final LocalDateTime date;
    private final int total;

    public AccountTransaction(TransactionType type, int value, LocalDateTime date, int total) {
        this.value = value;
        this.type = type;
        this.date = date;
        this.total = total;
    }

    public int value() {
        return value;
    }

    public TransactionType type() {
        return type;
    }

    public LocalDateTime date() {
        return date;
    }

    public int total() {
        return total;
    }
}
