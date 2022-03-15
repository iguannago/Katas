package patterns.strategy;

public class PigeonSinging implements SingBehaviour {
    @Override
    public String sign(String name) {
        return "I am a " + name + ". I can say: wow wow";
    }
}
