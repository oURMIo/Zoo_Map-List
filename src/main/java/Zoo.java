import animal.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zoo {
    private final List<Animal> list = new ArrayList<>();
    private int i = 0;

    Map<Integer, String> map1 = new HashMap<>();

    public int addAnimal(Animal animal) {
        list.add(animal);
        map1.put(i, animal.getName());
        i ++;
        return i - 1;
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
        final List<Animal> list2 = new ArrayList<>();
        for (int j = 0; j < list.size() - 1; j++) {
            if (vasya.equals(map1.get(j))) {
                list2.add(list.get(j));
            }
        }
        return list2;
    }
}
