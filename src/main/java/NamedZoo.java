import animal.Animal;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.logging.Logger;

import static java.util.Objects.requireNonNull;

/**
 * Decorator
 */
public class NamedZoo implements Zoo {
    private final Logger logger = Logger.getLogger("OMG");

    private final Zoo theZoo;
    private final Map<String, List<Animal>> name2Animal = new HashMap<>();

    public NamedZoo(Zoo zoo) {
        this.theZoo = zoo;
    }

    /**
     * Adds nonnull animal to zoo.
     *
     * @param animal animal to add.
     * @return positive number if added, -1 if can't be added.
     */
    @Override
    public int addAnimal(Animal animal) {
        requireNonNull(animal, "Can't add null");

        name2Animal.computeIfAbsent(animal.getName(), x -> new ArrayList<>()).add(animal);
        return theZoo.addAnimal(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        requireNonNull(animal, "Can't add null");

        name2Animal.computeIfPresent(animal.getName(), (x, animalList) -> {
            animalList.remove(animal);
            return animalList.isEmpty() ? null : animalList;
        });
        theZoo.removeAnimal(animal);
    }

    @Override
    public int getAnimalCount() {
        return theZoo.getAnimalCount();
    }

    @Override
    public @Nullable Animal getAnimalById(int id) {
        return theZoo.getAnimalById(id);
    }

    public List<Animal> geAnimalsByName(String name) {
        return name2Animal.getOrDefault(name, Collections.emptyList());
    }
}