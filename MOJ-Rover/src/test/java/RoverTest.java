import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;


/**
 * Created by davicres on 17/05/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class RoverTest {

    @Test
    @Parameters(method = "getInstructionAndExpectedDirection")
    public void roverTurnTest(String wording, String instruction, Position currentPosition, Position expectedPosition) {
        System.out.println(wording);
        Rover rover = Rover.create(currentPosition, instruction);
        Position actualPosition = rover.move();
        System.out.println(actualPosition);
        assertEquals(expectedPosition.toString(), actualPosition.toString());
    }

    /**
     * This method supplies all the different arguments for the different test cases. This is a elegant way to
     * comply with the DRY principle.
     * @return
     */
    private static final Object[] getInstructionAndExpectedDirection() {
        return new Object[][]{
                {"turnToEastTest" ,"R", Position.create(0,0, "N"), Position.create(0,0, "E")},
                {"turnToWestTest", "L", Position.create(0,0, "N"), Position.create(0,0, "W")},
                {"turnToSouthTest" ,"RR", Position.create(0,0, "N"), Position.create(0,0, "S")},
                {"turnToNorthTest" ,"RR", Position.create(0,0, "S"), Position.create(0,0, "N")},
                {"roverNorthMovementTest" ,"M", Position.create(0,0, "N"), Position.create(0,1, "N")},
                {"roverNorthMovementTwiceTest" ,"MM", Position.create(0,0, "N"), Position.create(0,2, "N")},
                {"roverRightMovementTest" ,"RM", Position.create(0,0, "N"), Position.create(1,0, "E")},
                {"roverLeftMovementTest" ,"LM", Position.create(0,0, "N"), Position.create(-1,0, "W")},
                {"roverSouthMovementTest" ,"RRM", Position.create(0,0, "N"), Position.create(0,-1, "S")},
                {"roverMovement1Test" ,"LMLMLMLMM", Position.create(1,2, "N"), Position.create(1,3, "N")},
                {"roverMovement2Test" ,"MMRMMRMRRM", Position.create(3,3, "E"), Position.create(5,1, "E")}
        };
    }

    //TODO; test corner cases such as limitation of the rectangle.

}
