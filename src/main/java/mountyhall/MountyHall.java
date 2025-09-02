package mountyhall;

import java.util.List;

public class MountyHall {
    private final List<Door> doors;
    private final Player player;

    public MountyHall(List<Door> doors, Player player) {
        this.doors = doors;
        this.player = player;
    }

    public List<Door> doors() {
        return this.doors;
    }

    public void playerSelectDoor(int doorNumber) {
        this.player.selectDoor(doorNumber);
    }

    public void openGoatDoor() {
        int indexDoorSelectedByPlayer = this.player.selectedDoor() - 1;
        for (int index = 0; index < this.doors.size(); index++) {
            if (index != indexDoorSelectedByPlayer && doors.get(index).hasGoat()) {
                this.doors.get(index).open();
                break;
            }
        }
    }

    public Door doorNumber(int door) {
        return this.doors.get(door - 1);
    }

    public int selectedDoor() {
        return this.player.selectedDoor();
    }

    public void switchDoor() {
        if (allDoorsAreClosed()) {
            throw new IllegalStateException("Cannot switch door when all doors are closed");
        }
        int indexDoorSelectedByPlayer = this.player.selectedDoor() - 1;
        int indexDoorOpen = this.doors.stream().filter(Door::isOpened).findFirst().map(doors::indexOf).orElse(-1);
        for (int index = 0; index < this.doors.size(); index++) {
            if (index != indexDoorSelectedByPlayer && index != indexDoorOpen) {
                this.player.selectDoor(index + 1);
                break;
            }
        }
    }

    private boolean allDoorsAreClosed() {
        return this.doors.stream().allMatch(Door::isClosed);
    }

    public boolean playerWins() {
        int indexDoor = this.player.selectedDoor() - 1;
        return this.doors.get(indexDoor).hasCar();
    }
}
