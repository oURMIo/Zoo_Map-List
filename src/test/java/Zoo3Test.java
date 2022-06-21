import animal.AnimalType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static animal.AnimalType.ELEPHANT;
import static animal.AnimalType.LION;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Zoo3Test {

    @ParameterizedTest
    @EnumSource(AnimalType.class)
    void addSmallAnimals(AnimalType animalType) {
        var zoo = new Zoo(animal -> animal.getType() != ELEPHANT);
        assertEquals(0, zoo.getAnimalCount(), "no animal inside");
        zoo.addAnimal(animalType.create("Petya"));
        if (animalType == ELEPHANT) {
            assertEquals(0, zoo.getAnimalCount(), "too small zoo for animal");
        } else {
            assertEquals(1, zoo.getAnimalCount(), "one animal inside");
        }
    }

    @ParameterizedTest
    @EnumSource(AnimalType.class)
    void addLionAnimal(AnimalType animalType) {
        var zoo = new Zoo(animal -> animal.getType() == LION);
        assertEquals(0, zoo.getAnimalCount(), "no animal inside");
        zoo.addAnimal(animalType.create("Petya"));
        if (animalType == LION) {
            assertEquals(0, zoo.getAnimalCount(), "we like cat-similar");
        } else {
            assertEquals(1, zoo.getAnimalCount(), "one animal inside");
        }
    }
}