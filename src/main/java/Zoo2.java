import animal.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zoo2 {
    private final List<Animal> list = new ArrayList<>();
    Map<String, List<Animal>> map1 = new HashMap<>();

    public int addAnimal(Animal animal) {
        //      new cool way
        list.add(animal);
        map1.computeIfAbsent(animal.getName(), k -> new ArrayList<>()).add(animal);
        return list.size() - 1;
    }

    public void removeAnimal(Animal animal) {
        list.remove(animal);
    }

    public int getAnimalCount() {
        return list.size();
    }

    public Animal getAnimalById(int vasyaNumber) {
        return list.get(vasyaNumber);
    }

    public List<Animal> geAnimalsByName(String vasya) {
        return map1.get(vasya);
    }
}
