import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by davicres on 17/05/2016.
 */
public class RoverTest {

    private final Position position = Position.create(0,0,'N');


    @Test
    public void roverMoveToTheRightTest() {
        Rover rover = Rover.create(position, "R");
        //TODO: improve the object assertion - how to compare objects.
        assertEquals(Position.create(0,0,'R').toString(), rover.move().toString());
    }

    @Test
    public void roverMoveToTheLeftTest() {
        Rover rover = Rover.create(position, "L");
        //TODO: improve the object assertion - how to compare objects.
        assertEquals(Position.create(0,0,'L').toString(), rover.move().toString());
    }
    //TODO: parameterise the above tests to obly with the DRY.



}
