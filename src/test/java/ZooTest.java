import animal.Animal;

import java.util.List;
import org.junit.jupiter.api.Test;

import static animal.AnimalType.LION;
import static animal.AnimalType.WOLF;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ZooTest {

    @Test
    void addAnimal() {
        var zoo = new StrategicalZoo();
        assertEquals(0, zoo.getAnimalCount(), "no animal inside");
        zoo.addAnimal(WOLF.create("Petya"));
        assertEquals(1, zoo.getAnimalCount(), "one animal inside");
    }

    @Test
    void removeAnimal() {
        var zoo = new StrategicalZoo();
        assertEquals(0, zoo.getAnimalCount(), "no animal inside");
        var animal = WOLF.create("Vasya");

        zoo.addAnimal(animal);
        assertEquals(1, zoo.getAnimalCount(), "one animal inside");

        zoo.removeAnimal(animal);
        assertEquals(0, zoo.getAnimalCount(), "no animal inside");
    }

    @Test
    void getAnimalByNumber() {
        var zoo = new StrategicalZoo();
        assertEquals(0, zoo.getAnimalCount(), "no animal inside");

        zoo.addAnimal(WOLF.create("Petya"));

        var vasya = WOLF.create("Vasya");
        int vasyaNumber = zoo.addAnimal(vasya);

        zoo.addAnimal(WOLF.create("Kolya"));

        assertEquals(3, zoo.getAnimalCount(), "all animal inside");

        assertEquals(vasya, zoo.getAnimalById(vasyaNumber), "Vasya should be found");
    }


    @Test
    void getAnimalsByNames() {
        var zoo = new NamedZoo(new StrategicalZoo());
        assertEquals(0, zoo.getAnimalCount(), "no animal inside");

        var petyaNameString = "Petya";
        zoo.addAnimal(WOLF.create(petyaNameString));

        var vasyaNameString = "Vasya";
        zoo.addAnimal(WOLF.create(vasyaNameString));
        zoo.addAnimal(LION.create(vasyaNameString));

        zoo.addAnimal(LION.create("KOLYA"));

        assertEquals(4, zoo.getAnimalCount(), "all animal inside");

        List<Animal> petyaAnimals = zoo.geAnimalsByName(petyaNameString);
        assertEquals(1, petyaAnimals.size(), "Petya should be 1 inside");

        List<Animal> vasyaAnimals = zoo.geAnimalsByName(vasyaNameString);
        assertEquals(2, vasyaAnimals.size(), "Vasya should be 2");
    }

}