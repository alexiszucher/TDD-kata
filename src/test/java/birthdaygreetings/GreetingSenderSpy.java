package birthdaygreetings;

import java.util.ArrayList;
import java.util.List;

class GreetingSenderSpy implements GreetingSender {
    private final List<Greeting> sentGreetings = new ArrayList<>();

    @Override
    public void send(Greeting greeting) {
        sentGreetings.add(greeting);
    }

    List<Greeting> sentGreetings() {
        return sentGreetings;
    }
}
