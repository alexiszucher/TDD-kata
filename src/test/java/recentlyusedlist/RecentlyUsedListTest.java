package recentlyusedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecentlyUsedListTest {
    @Test
    void shouldListBeEmptyAtTheBeginning() {
        RecentlyUsedList usedList = new RecentlyUsedList();
        assertEquals(0, usedList.list().size());
    }

    @Test
    void shouldInsertRecentlyWordIntoList() {
        RecentlyUsedList usedList = new RecentlyUsedList();
        usedList.insert("A recently word");
        assertEquals(1, usedList.list().size());
    }

    @Test
    void shouldTheMoreRecentWordIsAtFirstPosition() {
        RecentlyUsedList usedList = new RecentlyUsedList();
        usedList.insert("A recently word");
        usedList.insert("A second recently word");
        assertEquals(2, usedList.list().size());
        assertEquals("A second recently word", usedList.list().peek());
    }

    @Test
    void shouldRetrieveWordsWithIndex() {
        RecentlyUsedList usedList = new RecentlyUsedList();
        usedList.insert("A recently word");
        usedList.insert("A second recently word");
        assertEquals(2, usedList.list().size());
        assertEquals("A second recently word", usedList.list().get(0));
        assertEquals("A recently word", usedList.list().get(1));
    }

    @Test
    void givenWordAlreadyExist_shouldBePlacedAtFirstPosition() {
        RecentlyUsedList usedList = new RecentlyUsedList();
        usedList.insert("A recently word");
        usedList.insert("A second recently word");
        usedList.insert("A recently word");
        assertEquals(2, usedList.list().size());
        assertEquals("A recently word", usedList.list().get(0));
        assertEquals("A second recently word", usedList.list().get(1));
    }
}