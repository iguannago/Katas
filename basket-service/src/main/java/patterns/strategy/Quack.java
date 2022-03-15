package patterns.strategy;

public class Quack implements SingBehaviour {

    @Override
    public String sign(String name) {
        return "I am a " + name + ". I can say: Quack, Quack!";
    }
}
