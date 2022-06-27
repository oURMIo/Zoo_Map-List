import animal.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.jetbrains.annotations.Nullable;

import static java.util.Objects.requireNonNull;

/**
 * Zoo with adding/removing strategies.
 */
public class StrategicalZoo implements Zoo {
    private final Logger logger = Logger.getLogger(StrategicalZoo.class.getName());

    private final AddingStrategy addingStrategy;
    private final RemovingStrategy removingStrategy;

    private final List<Animal> animals = new ArrayList<>();
    private final Map<String, List<Animal>> name2Animal = new HashMap<>();

    public StrategicalZoo() {
        this.addingStrategy = x -> true;
        this.removingStrategy = x -> true;
    }

    public StrategicalZoo(AddingStrategy addingStrategy, RemovingStrategy removingStrategy) {
        this.addingStrategy = requireNonNull(addingStrategy, "addingStrategy");
        this.removingStrategy = requireNonNull(removingStrategy, "removingStrategy");
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

        if (addingStrategy.shouldAdd(animal)) {
            name2Animal.computeIfAbsent(animal.getName(), x -> new ArrayList<>()).add(animal);
            animals.add(animal);
            return animals.size() - 1;
        } else {
            return -1 /* not added */;
        }
    }

    @Override
    public void removeAnimal(Animal animal) {
        requireNonNull(animal, "Can't remove null");

        if (removingStrategy.shouldRemove(animal)) {
            name2Animal.computeIfPresent(animal.getName(), (x, animalList) -> {
                animalList.remove(animal);
                return animalList.isEmpty() ? null : animalList;
            });
            animals.remove(animal);
        } else {
            logger.warning("We haven't this animal");
        }
    }

    @Override
    public int getAnimalCount() {
        return animals.size();
    }

    @Override
    @Nullable
    public Animal getAnimalById(int id) {
        return animals.get(id);
    }

    public List<Animal> geAnimalsByName(String name) {
        return name2Animal.getOrDefault(name, Collections.emptyList());
    }
}
