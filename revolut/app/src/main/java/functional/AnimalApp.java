package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class AnimalApp {
    @FunctionalInterface
    public interface AnimalSound {
        String sound(String owner);
    }

    public static void main(String[] args) {

        Function<String, String> cat = name -> name + " miaow";
        Function<String, String> dog = name -> "woof " + name;
        List<Function<String, String>> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(dog);
        animals.forEach(a -> System.out.println(a.apply("David")));

        Predicate<Integer> isCarAffordable = price -> price <= 10000;
        System.out.println(isCarAffordable.test(5000));

        List<AnimalSound> animalSoundList = new ArrayList<>();
        animalSoundList.add(owner -> "woof " + owner);
        animalSoundList.add(owner -> owner + " miaow");

        animalSoundList.forEach(animalSound -> System.out.println(animalSound.sound("David")));
    }
}
