package patterns.strategy;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Bird duck = new Duck(new FlyALittle(), new Quack());
        Bird pigeon = new Pigeon(new FlyWellEnough(), new PigeonSinging());

        List<Bird> birds = List.of(duck, pigeon);
        birds.forEach(b -> {
            logger.log(Level.INFO, "{0}", b.fly());
            logger.log(Level.INFO, "{0}", b.sign());
        });
    }

}
