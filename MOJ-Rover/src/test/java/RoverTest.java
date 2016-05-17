import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by davicres on 17/05/2016.
 */
public class RoverTest {
    @Test
    public void roverMoveTest() {
        Position position = Position.create(0,0,'N');
        Instruction instruction = Instruction.create("R");
        Rover rover = Rover.create(position, instruction);
        assertEquals(Position.create(0,0,'R'), rover.move());
    }
}
