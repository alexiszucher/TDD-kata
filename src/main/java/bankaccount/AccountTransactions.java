package bankaccount;

import java.util.ArrayList;
import java.util.List;

public class AccountTransactions {
    public static final String SEPARATOR = " || ";
    public static final String LINE_BREAK = "\n";
    private final List<AccountTransaction> accountTransactions = new ArrayList<>();

    public void add(AccountTransaction accountTransaction) {
        accountTransactions.add(accountTransaction);
    }

    public List<AccountTransaction> transactions() {
        return accountTransactions;
    }

    public String printStatement() {
        StringBuilder sb = new StringBuilder();
        sb.append("Date       || Amount || Balance");
        accountTransactions.forEach(accountTransaction -> {
            int value = TransactionType.WITHDRAW.equals(accountTransaction.type()) ? -accountTransaction.value() : accountTransaction.value();
            sb.append(LINE_BREAK + accountTransaction.date().toLocalDate() + SEPARATOR +value+ SEPARATOR +accountTransaction.total());
        });
        return sb.toString();
    }
}
