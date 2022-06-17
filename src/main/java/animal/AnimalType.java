package animal;

public enum AnimalType {
    WOLF,
    BEAR,
    ELK,
    ELEPHANT,
    LION;

    public Animal create(String name){
        return new Animal(name, this);
    }

}
