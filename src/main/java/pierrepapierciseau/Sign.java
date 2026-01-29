package pierrepapierciseau;

enum Sign {
    SCISSORS() {
        @Override
        boolean beats(Sign sign) {
            return sign.equals(PAPER);
        }
    },
    PAPER() {
        @Override
        boolean beats(Sign sign) {
            return sign.equals(ROCK);
        }
    },
    ROCK() {
        @Override
        boolean beats(Sign sign) {
            return sign.equals(SCISSORS);
        }
    };

    abstract boolean beats(Sign sign);
}
