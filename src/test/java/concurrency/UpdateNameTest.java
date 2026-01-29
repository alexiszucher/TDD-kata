package concurrency;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UpdateNameTest {
    @Test
    void testUpdateName() {
        UpdateName updateName = new UpdateName();
        updateName.updateName("NewName");
        assertEquals("NewName", updateName.name);
    }

    @RepeatedTest(100)
    void testUpdateNameConcurrency() {
        UpdateName updateName = new UpdateName();
        Stream.generate(() -> 1).limit(100).parallel().forEach((x) -> {
            updateName.updateName("ConcurrentName" + Thread.currentThread().getId());
        });
        assertEquals("ConcurrentName11", updateName.name);
    }
}