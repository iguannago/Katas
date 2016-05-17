/**
 * Created by davicres on 17/05/2016.
 */
public final class Rover {
    private final Position position;
    private final String instruction;

    private Rover(Position position, String instruction) {
        this.position = position;
        this.instruction = instruction;
    }

    public static Rover create(Position position, String instruction) {
        return new Rover(position, instruction);
    }

    public Position move() {
        return recursiveMove(instruction, position);
    }

    private Position recursiveMove(String instruction, Position position) {
        if (instruction.isEmpty())
            return position;
        if (instruction.charAt(0) == 'M') {
            if (position.getDirection() == 'N')
                return recursiveMove(instruction.substring(1), Position.create(position.getX(),
                        position.getY() + 1, 'N'));
        }
        return recursiveMove(instruction.substring(1), Position.create(0, 0,
                instruction.charAt(0)));
    }

    @Override
    public String toString() {
        return "Rover{" +
                "position=" + position +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
