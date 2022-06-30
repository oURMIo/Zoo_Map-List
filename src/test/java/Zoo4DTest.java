import animal.AnimalType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.logging.Logger;

import static animal.AnimalType.*;
import static org.junit.jupiter.api.Assertions.*;

class Zoo4DTest {
    private final Logger logger = Logger.getLogger(Zoo4DTest.class.getName());

    @ParameterizedTest
    @EnumSource(AnimalType.class)
    void findBug() {
        var zoo = new StrategicalZoo();
        var animal = WOLF.create("Radion");    /*   for assertEquals   */
        zoo.addAnimal(WOLF.create("Radion"));  /* in list 0 */
        zoo.addAnimal(BEAR.create("Kosolap"));  /* in list 1 */
        zoo.addAnimal(LION.create("Lion"));  /* in list 2 */
        assertEquals(animal, zoo.getAnimalById(0));
        logger.info("/////   OLD    ///// -    " + zoo.getAnimalById(0));
        zoo.removeAnimal(zoo.getAnimalById(0));
        logger.info("/////   NOW    ///// -    " + zoo.getAnimalById(0));
        assertNull(zoo.getAnimalById(0));

    }
}