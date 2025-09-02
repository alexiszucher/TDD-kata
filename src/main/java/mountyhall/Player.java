package mountyhall;

public class Player {
    private int selectedDoor;

    public void selectDoor(int doorNumber) {
        this.selectedDoor = doorNumber;
    }

    public int selectedDoor() {
        return this.selectedDoor;
    }
}
