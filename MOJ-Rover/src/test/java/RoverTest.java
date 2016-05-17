import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by davicres on 17/05/2016.
 */
public class RoverTest {

    private final Position position = Position.create(0,0,'N');

    @Test
    public void roverTurnToEastTest() {
        Rover rover = Rover.create(position, "R");
        //TODO: improve the object assertion - how to compare objects.
        System.out.println(rover.move());
        assertEquals(Position.create(0,0,'E').toString(), rover.move().toString());
    }

    @Test
    public void roverTurnToWestTest() {
        Rover rover = Rover.create(position, "L");
        //TODO: improve the object assertion - how to compare objects.
        System.out.println(rover.move());
        assertEquals(Position.create(0,0,'W').toString(), rover.move().toString());
    }

    @Test
    public void roverTurnToSouthTest() {
        Rover rover = Rover.create(position, "RR");
        //TODO: improve the object assertion - how to compare objects.
        System.out.println(rover.move());
        assertEquals(Position.create(0,0,'S').toString(), rover.move().toString());
    }

    @Test
    public void roverTurnToNorthTest() {
        Rover rover = Rover.create(Position.create(0,0,'S'), "RR");
        //TODO: improve the object assertion - how to compare objects.
        System.out.println(rover.move());
        assertEquals(Position.create(0,0,'N').toString(), rover.move().toString());
    }
    //TODO: parameterise the above tests to obly with the DRY.

    @Test
    public void roverNorthMovementTest() {
        Rover rover = Rover.create(position, "M");
        //TODO: improve the object assertion - how to compare objects.
        System.out.println(rover.move());
        assertEquals(Position.create(0,1,'N').toString(), rover.move().toString());
    }

    @Test
    public void roverNorthMovementTwiceTest() {
        Rover rover = Rover.create(position, "MM");
        //TODO: improve the object assertion - how to compare objects.
        System.out.println(rover.move());
        assertEquals(Position.create(0,2,'N').toString(), rover.move().toString());
    }

    @Test
    public void roverRightMovementTest() {
        Rover rover = Rover.create(position, "RM");
        //TODO: improve the object assertion - how to compare objects.
        System.out.println(rover.move());
        assertEquals(Position.create(1,0,'E').toString(), rover.move().toString());
    }

    @Test
    public void roverLeftMovementTest() {
        Rover rover = Rover.create(position, "LM");
        //TODO: improve the object assertion - how to compare objects.
        System.out.println(rover.move());
        assertEquals(Position.create(-1,0,'W').toString(), rover.move().toString());
    }

    @Test
    public void roverSouthMovementTest() {
        Rover rover = Rover.create(position, "RRM");
        //TODO: improve the object assertion - how to compare objects.
        System.out.println(rover.move());
        assertEquals(Position.create(0,-1,'S').toString(), rover.move().toString());
    }

    @Test
    public void roverMovement1Test() {
        Rover rover = Rover.create(Position.create(1,2,'N'), "LMLMLMLMM");
        System.out.println(rover.move());
        assertEquals(Position.create(1,3,'N').toString(), rover.move().toString());
    }

    @Test
    public void roverMovement2Test() {
        Rover rover = Rover.create(Position.create(3,3,'E'), "MMRMMRMRRM");
        System.out.println(rover.move());
        assertEquals(Position.create(5,1,'E').toString(), rover.move().toString());
    }


}
