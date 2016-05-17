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
        for (int i = 0; i < instruction.length(); i++) {
            if (instruction.charAt(i) == 'M') {
                if (position.getDirection() == 'N')
                   return Position.create(position.getX(), position.getY() + 1, 'N');
            }
            return Position.create(0,0, instruction.charAt(instruction.length()-1));
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
