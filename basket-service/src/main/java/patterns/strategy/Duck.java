package patterns.strategy;

public class Duck extends Bird {

    protected Duck(FlyBehaviour flyBehaviour, SingBehaviour singBehaviour) {
        super.setFlyBehaviour(flyBehaviour);
        super.setSingBehaviour(singBehaviour);
        super.setName("Duck");
    }

}
