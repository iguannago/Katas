/**
 * Created by davicres on 17/05/2016.
 */
public final class Rover {
    private final Position position;
    private final Instruction instruction;

    private Rover(Position position, Instruction instruction) {
        this.position = position;
        this.instruction = instruction;
    }

    public static Rover create(Position position, Instruction instruction) {
        return new Rover(position, instruction);
    }

    public Position move() {
        return position;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "position=" + position +
                ", instruction=" + instruction +
                '}';
    }
}
