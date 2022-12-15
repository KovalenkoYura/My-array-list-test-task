package core.basesyntax;

public interface List<T> {
    void add(T value);

    void add(T value, int index);

    T get(int index);

    void set(T value, int index);

    T remove(int index);

    int size();

    boolean isEmpty();
}
