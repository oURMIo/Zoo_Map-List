import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import static animal.AnimalType.ELEPHANT;
import static animal.AnimalType.LION;
import static animal.AnimalType.WOLF;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ZooDecoratorDTest {
    private final Logger logger = Logger.getLogger(ZooDecoratorDTest.class.getName());

    @Test
    void findBug() {
        var zoo = new NamedZoo(new StrategicalZoo(a -> a.getType() != ELEPHANT, b -> b.getType() != LION));

        zoo.addAnimal(WOLF.create("Gray"));
        var pink = ELEPHANT.create("Pink");
        zoo.addAnimal(pink);
        var king = LION.create("King");
        zoo.addAnimal(king);

        assertEquals(2, zoo.getAnimalCount(), "all but elephant is added");
        assertNull(zoo.geAnimalsByName(pink.getName()), "Pink elephant is expected to be out of zoo");

        zoo.removeAnimal(king);
        assertEquals(2, zoo.getAnimalCount(), "lion is not removed");
        assertNotNull(zoo.geAnimalsByName("King"), "King is expected to be in zoo");
    }
}