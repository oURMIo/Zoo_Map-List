import animal.Animal;

@FunctionalInterface
public interface AddingStrategy {
    boolean shouldAdd(Animal animal);
}
