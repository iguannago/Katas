package functional;

import java.util.ArrayList;
import java.util.List;

public class AnimalApp {
    @FunctionalInterface
    public interface AnimalSound {
        String sound(String owner);
    }

    public static void main(String[] args) {
        List<AnimalSound> animalSoundList = new ArrayList<>();
        animalSoundList.add(owner -> "woof " + owner);
        animalSoundList.add(owner -> owner + " miaow");

        animalSoundList.forEach(animalSound -> System.out.println(animalSound.sound("David")));
    }
}
