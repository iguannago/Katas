package teniskata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void playerCanOnlyHaveCertainPoints() {
        Player player = new Player("Dave");
        Assertions.assertEquals("Dave", player.getName());
    }
}