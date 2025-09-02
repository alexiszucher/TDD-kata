package mountyhall;

import org.junit.jupiter.api.Test;

class MountyHallSimulationTest {
    @Test
    void shouldRunASimulation() {
        MountyHallSimulation.simulate1000Games(false);
        MountyHallSimulation.simulate1000Games(true);
    }
}