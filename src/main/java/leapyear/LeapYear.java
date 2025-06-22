package leapyear;

import java.util.function.Predicate;

public class LeapYear {
    private static final Predicate<Integer> ATYPICAL_COMMON_YEAR = (year) -> year % 100 == 0 && year % 400 != 0;
    private static final Predicate<Integer> TYPICAL_LEAP_YEAR = (year) -> year % 4 == 0;

    public static boolean isLeapYear(int year) {
        if (ATYPICAL_COMMON_YEAR.test(year)) {
            return false;
        }
        if (TYPICAL_LEAP_YEAR.test(year)) {
            return true;
        }
        return false;
    }
}
