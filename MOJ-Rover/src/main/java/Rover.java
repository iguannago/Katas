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

        if (position.getDirection() == 'N') {
            if (instruction.charAt(0) == 'R')
                return recursiveMove(instruction.substring(1), Position.create(position.getX(), position.getY(), 'E'));
            if (instruction.charAt(0) == 'L')
                return recursiveMove(instruction.substring(1), Position.create(position.getX(), position.getY(), 'W'));
            if (instruction.charAt(0) == 'M')
                return recursiveMove(instruction.substring(1), Position.create(position.getX(), position.getY() + 1, 'N'));
        }

        if (position.getDirection() == 'E') {
            if (instruction.charAt(0) == 'R')
                return recursiveMove(instruction.substring(1), Position.create(position.getX(), position.getY(), 'S'));
            if (instruction.charAt(0) == 'L')
                return recursiveMove(instruction.substring(1), Position.create(position.getX(), position.getY(), 'N'));
            if (instruction.charAt(0) == 'M')
                return recursiveMove(instruction.substring(1), Position.create(position.getX() + 1, position.getY(), 'E'));
        }

        if (position.getDirection() == 'W') {
            if (instruction.charAt(0) == 'R')
                return recursiveMove(instruction.substring(1), Position.create(position.getX(), position.getY(), 'N'));
            if (instruction.charAt(0) == 'L')
                return recursiveMove(instruction.substring(1), Position.create(position.getX(), position.getY(), 'S'));
            if (instruction.charAt(0) == 'M')
                return recursiveMove(instruction.substring(1), Position.create(position.getX() - 1, position.getY(), 'W'));
        }

        if (position.getDirection() == 'S') {
            if (instruction.charAt(0) == 'R')
                return recursiveMove(instruction.substring(1), Position.create(position.getX(), position.getY(), 'W'));
            if (instruction.charAt(0) == 'L')
                return recursiveMove(instruction.substring(1), Position.create(position.getX(), position.getY(), 'E'));
            if (instruction.charAt(0) == 'M')
                return recursiveMove(instruction.substring(1), Position.create(position.getX(), position.getY() - 1, 'S'));

        }

        throw new RuntimeException("Something went wrong");
    }

    @Override
    public String toString() {
        return "Rover{" +
                "position=" + position +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
