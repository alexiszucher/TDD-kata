package birthdaygreetings;

import java.util.ArrayList;
import java.util.List;

class InMemoryFriends implements Friends {
    private final List<Friend> friends = new ArrayList<>();

    void add(Friend friend) {
        friends.add(friend);
    }

    @Override
    public List<Friend> all() {
        return friends;
    }
}
