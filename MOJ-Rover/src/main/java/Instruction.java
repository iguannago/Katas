/**
 * Created by davicres on 17/05/2016.
 */
public final class Instruction {
    private final String movement;

    private Instruction(String movement) {
        this.movement = movement;
    }

    public static Instruction create(String movement) {
        return new Instruction(movement);
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "movement='" + movement + '\'' +
                '}';
    }
}
