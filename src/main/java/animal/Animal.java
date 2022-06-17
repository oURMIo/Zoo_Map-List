package animal;

public class Animal {
    private final String name;
    private final AnimalType type;

    Animal(String name, AnimalType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
