package patterns.strategy;

public class Pigeon extends Bird {
    public Pigeon(FlyBehaviour flyBehaviour, SingBehaviour singBehaviour) {
        super.setFlyBehaviour(flyBehaviour);
        super.setSingBehaviour(singBehaviour);
        super.setName("Pigeon");
    }

}
