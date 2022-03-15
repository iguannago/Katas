package patterns.strategy;

public class FlyALittle implements FlyBehaviour {

    @Override
    public String fly(String name) {
        return "I am a " + name + ". I can fly a little";
    }
}
