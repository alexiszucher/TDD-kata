package molkky;

import java.util.List;

public class Roll {
    private final List<Integer> pinsDown;

    public Roll(List<Integer> pinsDown) {
        this.pinsDown = pinsDown;
    }

    public int totalScore() {
        if (onePinDown()) {
            return pinsDown.get(0);
        }
        return pinsDown.size();
    }

    private boolean onePinDown() {
        return pinsDown.size() == 1;
    }
}
