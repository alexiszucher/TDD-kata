package recentlyusedlist;
import java.util.LinkedList;

public class RecentlyUsedList {
    private final LinkedList<String> list;

    public RecentlyUsedList() {
        this.list = new LinkedList<>();
    }

    public LinkedList<String> list() {
        return this.list;
    }

    public void insert(String recentlyWord) {
        if (wordIsAlreadyOnList(recentlyWord)) {
            this.list.remove(recentlyWord);
        }
        this.list.addFirst(recentlyWord);
    }

    private boolean wordIsAlreadyOnList(String word) {
        return list.contains(word);
    }
}