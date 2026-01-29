package concurrency;

import java.util.concurrent.locks.Lock;

public class UpdateName {
    public String name = "InitialName";

    public void updateName(String newName) {
        Lock lock = new java.util.concurrent.locks.ReentrantLock();
        lock.lock();
        this.name = newName;
        lock.unlock();
    }
}
