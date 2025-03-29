package bankaccount;

import java.time.LocalDateTime;
import java.util.List;

import static bankaccount.TransactionType.WITHDRAW;

public class Account {
    private int amount;
    private final AccountTransactions accountTransactions = new AccountTransactions();

    public Account(int amount) {
        this.amount = amount;
    }

    public int total() {
        return amount;
    }

    public void withdraw(int value) {
        amount -= value;
        accountTransactions.add(new AccountTransaction(WITHDRAW, value, LocalDateTime.now(BankClock.CLOCK), amount));
    }

    public List<AccountTransaction> history() {
        return accountTransactions.transactions();
    }
}
