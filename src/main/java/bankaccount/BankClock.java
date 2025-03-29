package bankaccount;

import java.time.*;

public class BankClock {
    private BankClock() {}

    public static Clock CLOCK = Clock.systemDefaultZone();

    public static void change(LocalDateTime localDateTime) {
        Instant instant = ZonedDateTime.of(localDateTime, ZoneId.systemDefault()).toInstant();
        CLOCK = Clock.fixed(instant, ZoneId.systemDefault());
    }

    public static void reset() {
        CLOCK = Clock.systemDefaultZone();
    }
}
