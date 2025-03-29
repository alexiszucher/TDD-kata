package bankaccount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AccountTransactionsTest {
    private static final LocalDateTime JANUARY_1ST_AT_3PM = LocalDateTime.of(2025, 1, 1, 15, 0);

    @Test
    void whenPrintStatement_shouldShowDateAmountAndBalanceTitles() {
        AccountTransactions accountTransactions = new AccountTransactions();
        Assertions.assertEquals("""
                Date       || Amount || Balance""", accountTransactions.printStatement());
    }

    @Test
    void whenPrintStatement_shouldShowTransactions() {
        AccountTransactions accountTransactions = new AccountTransactions();
        accountTransactions.add(new AccountTransaction(TransactionType.WITHDRAW, 30, JANUARY_1ST_AT_3PM, 270));
        Assertions.assertEquals("""
                Date       || Amount || Balance
                2025-01-01 || -30 || 270""", accountTransactions.printStatement());
    }
}