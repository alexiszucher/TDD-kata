package birthdaygreetings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class SendBirthdayGreetingsUseCaseTest {
    private static final LocalDate OCTOBER_8_2026 = LocalDate.of(2026, 10, 8);

    private final InMemoryFriends friends = new InMemoryFriends();
    private final GreetingSenderSpy greetingSender = new GreetingSenderSpy();
    private final SendBirthdayGreetingsUseCase useCase = new SendBirthdayGreetingsUseCase(friends, greetingSender);

    @Test
    void givenNoFriends_shouldSendNoGreeting() {
        useCase.sendGreetings(OCTOBER_8_2026);

        Assertions.assertTrue(greetingSender.sentGreetings().isEmpty());
    }

    @Test
    void givenFriendsBornOnThisDay_shouldWishEachOfThemHappyBirthday() {
        Friend john = new Friend("Doe", "John", LocalDate.of(1982, 10, 8), "john.doe@example.com");
        Friend jane = new Friend("Roe", "Jane", LocalDate.of(1990, 10, 8), "jane.roe@example.com");
        friends.add(john);
        friends.add(jane);

        useCase.sendGreetings(OCTOBER_8_2026);

        Assertions.assertEquals(
                List.of(
                        new Greeting(john, "Happy birthday!", "Happy birthday, dear John!"),
                        new Greeting(jane, "Happy birthday!", "Happy birthday, dear Jane!")),
                greetingSender.sentGreetings());
    }

    @Test
    void givenAFriendNotBornOnThisDay_shouldSendNoGreeting() {
        friends.add(new Friend("Ann", "Mary", LocalDate.of(1975, 9, 11), "mary.ann@example.com"));

        useCase.sendGreetings(OCTOBER_8_2026);

        Assertions.assertTrue(greetingSender.sentGreetings().isEmpty());
    }
}
