package mastermind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static mastermind.ColorVerification.*;

public class Mastermind {
    private final Map<Integer, Color> masterColors;

    public Mastermind(Map<Integer, Color> masterColors) {
        this.masterColors = masterColors;
    }

    public Map<Integer, ColorVerification> play(Map<Integer, Color> proposedColors) {
        Map<Integer, Color> masterColorsVerification = new HashMap<>(masterColors);
        proposedColors = new HashMap<>(proposedColors);
        Map<Integer, ColorVerification> result = new HashMap<>();

        computeBlackPositions(proposedColors, masterColorsVerification, result);
        computeWhiteAndNothingPositions(proposedColors, masterColorsVerification, result);
        return result;
    }

    private void computeWhiteAndNothingPositions(Map<Integer, Color> proposedColors, Map<Integer, Color> masterColorsVerification, Map<Integer, ColorVerification> result) {
        proposedColors.forEach((position, proposedColor) -> {
            if (masterColorsHasProposedColor(proposedColor, masterColorsVerification)) {
                result.put(position, WHITE);
            } else {
                result.put(position, NOTHING);
            }
        });
    }

    private void computeBlackPositions(Map<Integer, Color> proposedColors, Map<Integer, Color> masterColorsVerification, Map<Integer, ColorVerification> result) {
        List<Integer> blackPositions = new ArrayList<>();
        proposedColors.forEach((position, proposedColor) -> {
            if (proposedColorIsOnRightPlacement(proposedColor, position, masterColorsVerification)) {
                result.put(position, BLACK);
                blackPositions.add(position);
            }
        });
        blackPositions.forEach(masterColorsVerification::remove);
        blackPositions.forEach(proposedColors::remove);
    }

    private boolean masterColorsHasProposedColor(Color proposedColor, Map<Integer, Color> masterColors) {
        return masterColors.containsValue(proposedColor);
    }

    private boolean proposedColorIsOnRightPlacement(Color proposedColor, int position, Map<Integer, Color> masterColors) {
        return masterColors.get(position) == proposedColor;
    }
}
