import animal.Animal;

import org.jetbrains.annotations.Nullable;

public interface Zoo {
    /**
     * Adds nonnull animal to zoo.
     *
     * @param animal animal to add.
     * @return positive number if added, -1 if can't be added.
     */
    int addAnimal(Animal animal);

    /**
     * Removes nonnull animal to zoo.
     *
     * @param animal animal to remove
     */
    void removeAnimal(Animal animal);

    /**
     * How many animal in Zoo.
     *
     * @return how many animal in Zoo.
     */
    int getAnimalCount();

    /**
     * Return animal by id, that add was returned.
     *
     * @deprecated marked for remove.
     * @param id id, returned by added.
     * @return animal or null if not found.
     */
    @Nullable
    @Deprecated(since = "now")
    Animal getAnimalById(int id);
}
