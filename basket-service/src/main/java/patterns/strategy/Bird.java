package patterns.strategy;

public abstract class Bird {

    private FlyBehaviour flyBehaviour;
    private SingBehaviour singBehaviour;
    private String name;

    public String fly() {
        return flyBehaviour.fly(name);
    }

    public String sign() {
        return singBehaviour.sign(name);
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void setSingBehaviour(SingBehaviour singBehaviour) {
        this.singBehaviour = singBehaviour;
    }

    public void setName(String name) {
        this.name = name;
    }
}
