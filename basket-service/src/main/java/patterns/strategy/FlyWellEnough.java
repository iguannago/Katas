package patterns.strategy;

public class FlyWellEnough implements FlyBehaviour {
    @Override
    public String fly(String name) {
        return "I am a " + name + ". I can fly well enough";
    }
}
