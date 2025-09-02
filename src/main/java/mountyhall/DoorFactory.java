package mountyhall;

import java.util.List;

public class DoorFactory {
    public static List<Door> generateThreeDoors() {
        double random = Math.random();
        if (random < 0.33)
            return List.of(Door.buildWithGoat(), Door.buildWithCar(), Door.buildWithGoat());
        else if (random < 0.66)
            return List.of(Door.buildWithCar(), Door.buildWithGoat(), Door.buildWithGoat());
        else
            return List.of(Door.buildWithGoat(), Door.buildWithGoat(), Door.buildWithCar());
    }
}
