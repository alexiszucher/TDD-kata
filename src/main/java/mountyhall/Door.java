package mountyhall;

import static mountyhall.DoorContent.CAR;
import static mountyhall.DoorContent.GOAT;

public class Door {
    private final DoorContent content;
    private boolean closed = true;

    private Door(DoorContent content) {
        this.content = content;
    }

    public static Door buildWithGoat() {
        return new Door(GOAT);
    }

    public static Door buildWithCar() {
        return new Door(CAR);
    }

    public boolean hasGoat() {
        return this.content == GOAT;
    }

    public boolean hasCar() {
        return this.content == CAR;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public boolean isOpened() {
        return !this.closed;
    }

    public void open() {
        this.closed = false;
    }
}

enum DoorContent {
    GOAT,
    CAR
}


