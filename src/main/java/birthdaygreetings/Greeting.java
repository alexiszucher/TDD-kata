package birthdaygreetings;

public record Greeting(Friend recipient, String subject, String body) {
    public static Greeting birthdayOf(Friend friend) {
        return new Greeting(friend, "Happy birthday!", "Happy birthday, dear " + friend.firstName() + "!");
    }
}
