import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by davicres on 17/05/2016.
 */
public class RoverTest {

    private final Position position = Position.create(0,0,'N');

    @Test
    public void roverTurnToRightTest() {
        Rover rover = Rover.create(position, "R");
        //TODO: improve the object assertion - how to compare objects.
        assertEquals(Position.create(0,0,'R').toString(), rover.move().toString());
    }

    @Test
    public void roverTurnToLeftTest() {
        Rover rover = Rover.create(position, "L");
        //TODO: improve the object assertion - how to compare objects.
        assertEquals(Position.create(0,0,'L').toString(), rover.move().toString());
    }
    //TODO: parameterise the above tests to obly with the DRY.

    @Test
    public void roverNorthMovementTest() {
        Rover rover = Rover.create(position, "M");
        //TODO: improve the object assertion - how to compare objects.
        assertEquals(Position.create(0,1,'N').toString(), rover.move().toString());
    }

    @Test
    public void roverNorthMovementTwiceTest() {
        Rover rover = Rover.create(position, "MM");
        //TODO: improve the object assertion - how to compare objects.
        assertEquals(Position.create(0,2,'N').toString(), rover.move().toString());
    }

    @Test@Ignore
    public void roverRightMovementTest() {
        Rover rover = Rover.create(position, "RM");
        //TODO: improve the object assertion - how to compare objects.
        assertEquals(Position.create(1,0,'N').toString(), rover.move().toString());
    }




}
