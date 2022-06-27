import animal.Animal;

@FunctionalInterface
public interface RemovingStrategy {
    boolean shouldRemove(Animal animal);
}
