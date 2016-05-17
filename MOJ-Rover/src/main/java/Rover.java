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
        return Position.create(0,0, instruction.charAt(instruction.length()-1));
    }

    @Override
    public String toString() {
        return "Rover{" +
                "position=" + position +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
