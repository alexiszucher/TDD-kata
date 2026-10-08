package birthdaygreetings;

import java.time.LocalDate;
import java.time.MonthDay;

public record Friend(String lastName, String firstName, LocalDate dateOfBirth, String email) {
    public boolean isBirthday(LocalDate today) {
        return MonthDay.from(dateOfBirth).equals(MonthDay.from(today));
    }
}
