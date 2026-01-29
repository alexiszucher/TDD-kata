package pierrepapierciseau;

import java.util.Optional;

class Game {
    public static Optional<Sign> winnerBetween(Sign signOne, Sign signTwo) {
        if (signOne.beats(signTwo)) {
            return Optional.of(signOne);
        } else if (signTwo.beats(signOne)) {
            return Optional.of(signTwo);
        }
        return Optional.empty();
    }
}
