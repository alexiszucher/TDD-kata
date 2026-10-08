package birthdaygreetings;

import java.time.LocalDate;

public class SendBirthdayGreetingsUseCase {
    private final Friends friends;
    private final GreetingSender greetingSender;

    public SendBirthdayGreetingsUseCase(Friends friends, GreetingSender greetingSender) {
        this.friends = friends;
        this.greetingSender = greetingSender;
    }

    public void sendGreetings(LocalDate today) {
        friends.all().stream()
                .filter(friend -> friend.isBirthday(today))
                .map(Greeting::birthdayOf)
                .forEach(greetingSender::send);
    }
}
