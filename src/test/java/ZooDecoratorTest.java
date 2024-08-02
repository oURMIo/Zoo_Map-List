import java.util.Collections;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import static animal.AnimalType.ELEPHANT;
import static animal.AnimalType.LION;
import static animal.AnimalType.WOLF;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ZooDecoratorTest {
    private final Logger logger = Logger.getLogger(ZooDecoratorTest.class.getName());

    @Test
    void findBug() {
        var zoo = new NamedZoo(new StrategicalZoo(a -> a.getType() != ELEPHANT, b -> b.getType() != LION));

        zoo.addAnimal(WOLF.create("Gray"));
        var pink = ELEPHANT.create("Pink");
        zoo.addAnimal(pink);
        var king = LION.create("King");
        zoo.addAnimal(king);

        assertEquals(2, zoo.getAnimalCount(), "all but elephant is added");
        assertEquals(Collections.EMPTY_LIST,zoo.geAnimalsByName(pink.getName()));

        zoo.removeAnimal(king);
        assertEquals(2, zoo.getAnimalCount(), "lion is not removed");
        assertNotNull(zoo.geAnimalsByName("King"), "King is expected to be in zoo");
    }
}