package patterns.strategy;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Bird duck = new Duck(new FlyALittle(), new Quack());
        logger.log(Level.INFO, "{0}", duck.fly());
        logger.log(Level.INFO, "{0}", duck.sign());

        Bird pigeon = new Pigeon(new FlyWellEnough(), new PigeonSinging());
        logger.log(Level.INFO, "{0}", pigeon.fly());
        logger.log(Level.INFO, "{0}", pigeon.sign());

    }

}
