import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by davicres on 17/05/2016.
 */
public class MarsRoverApp {
    public static void main(String[] args) {
        List<Rover> rovers = new ArrayList<Rover>();
        List<String> testInput = Arrays.asList("5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM");
        String[] plateauXYUpperRightLimit = testInput.get(0).split(" ");

        initializeRoversList(rovers, testInput);

        listRovers(rovers);

        listRoverPositionAfterInstrunction(rovers);
    }

    private static void listRoverPositionAfterInstrunction(List<Rover> rovers) {
        for (Rover rover: rovers) {
            System.out.println(rover.move());
            //TODO: we could manage if the Rover is out of the plateau limitation if there was such a requirement.
        }
    }

    private static void listRovers(List<Rover> rovers) {
        for (Rover rover: rovers) {
            System.out.println(rover);
        }
    }

    private static void initializeRoversList(List<Rover> rovers, List<String> testInput) {
        for (int i = 1; i < testInput.size(); i++) {
            if (i % 2 != 0) {
            String[] pos = testInput.get(i).split(" ");
            Position position = Position.create(Integer.valueOf(pos[0]), Integer.valueOf(pos[1]), pos[2]);
            Rover rover = Rover.create(position, testInput.get(i+1));
            rovers.add(rover);
            }
        }
    }
}
