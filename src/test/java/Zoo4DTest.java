import animal.Animal;
import animal.AnimalType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Objects;
import java.util.logging.Logger;

import static animal.AnimalType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Zoo4DTest {
    private final Logger logger = Logger.getLogger(Zoo4DTest.class.getName());

    /**
     * for compare two Animal obj
     *
     * @param need - Animal obj
     * @param now - Animal obj
     * @return 0 or -1
     */
    int compareAnimal(Animal need, Animal now) {
        if (Objects.equals(need, now)) {
            return 0;
        }
        return -1;
    }

    @ParameterizedTest
    @EnumSource(AnimalType.class)
    void findBag() {
        var zoo = new StrategicalZoo();
        var animal = WOLF.create("Radion");    /*   for assertEquals   */
        zoo.addAnimal(WOLF.create("Radion"));  /* in list 0 */
        zoo.addAnimal(BEAR.create("Kosolap"));  /* in list 1 */
        zoo.addAnimal(LION.create("Lion"));  /* in list 2 */
        assertEquals(0, compareAnimal(animal, zoo.getAnimalById(0)));
//        logger.info("/////   OLD    ///// -    " + zoo.getAnimalById(0));
        zoo.removeAnimal(zoo.getAnimalById(0));
//        logger.info("/////   NOW    ///// -    " + zoo.getAnimalById(0));
        assertEquals(0, compareAnimal(null, zoo.getAnimalById(0)));
    }
}