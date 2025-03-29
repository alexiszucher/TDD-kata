package bankaccount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class AccountTest {
    private static final LocalDateTime JANUARY_1ST_AT_3PM = LocalDateTime.of(2025, 1, 1, 15, 0);

    @Test
    void given500euros_whenWithdraw143_myAccountShouldHave357() {
        Account account = new Account(500);
        account.withdraw(143);
        Assertions.assertEquals(357, account.total());
    }

    @Test
    void whenAWithdrawActionIsExecuted_thenHistoryIsFilled() {
        Account account = new Account(500);
        Assertions.assertEquals(0, account.history().size());
        BankClock.change(JANUARY_1ST_AT_3PM);

        account.withdraw(143);

        Assertions.assertEquals(1, account.history().size());
        AccountTransaction transaction = account.history().iterator().next();
        Assertions.assertEquals(143, transaction.value());
        Assertions.assertEquals(TransactionType.WITHDRAW, transaction.type());
        Assertions.assertEquals(JANUARY_1ST_AT_3PM, transaction.date());
        Assertions.assertEquals(357, transaction.total());
    }
}