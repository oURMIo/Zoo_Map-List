import animal.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zoo {
    private final List<Animal> list = new ArrayList<>();
    private final AddingStrategy addingStrategy;
    private final RemoveingStrategy removeingStrategy;
    Map<Integer, String> map1 = new HashMap<>();

    public Zoo() {
        addingStrategy = null;
        removeingStrategy = null;
    }

    public Zoo(AddingStrategy strategy, RemoveingStrategy removeingStrategy) {
        this.addingStrategy = strategy;
        this.removeingStrategy = removeingStrategy;
    }
    //Function<Animal,Boolean> a1

    public int addAnimal(Animal animal) {
        if (addingStrategy != null && addingStrategy.shouldAd(animal)) {
            list.add(animal);
            return list.size() - 1;
        } else {
            return -1;
        }
    }

    public void removeAnimal(Animal animal) {
        if (removeingStrategy != null && removeingStrategy.shouldRemove(animal)) {
            list.remove(animal);
        } else {
            System.out.println("We haven't this animal");
        }
    }

    public int getAnimalCount() {
        return list.size();
    }

    public Animal getAnimalById(int vasyaNumber) {
        return list.get(vasyaNumber);
    }

    public List<Animal> geAnimalsByName(String vasya) {
        final List<Animal> list2 = new ArrayList<>();
        for (int j = 0; j < list.size() - 1; j++) {
            if (vasya.equals(map1.get(j))) {
                list2.add(list.get(j));
            }
        }
        return list2;
    }
}
