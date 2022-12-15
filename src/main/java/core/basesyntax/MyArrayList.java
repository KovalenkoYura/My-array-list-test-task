package core.basesyntax;

import java.util.Objects;


public class MyArrayList<T> implements List<T> {
  private static final int DEFAULT_CAPACITY = 5;
  private Object[] elements;
  private int size;
  private int newLength = (int) (elements.length * 1.5);

  public MyArrayList(int initCapacity) {
    if (initCapacity <= 0) {
      throw new ArrayListIndexOutOfBoundsException("Error");
    }
    elements = new Object[initCapacity];
  }

  public MyArrayList() {
    this(DEFAULT_CAPACITY);
  }

  @Override
  public void add(T value) {
    resizeIfItNeeded();
    elements[size] = value;
    size++;
  }

  private void resizeIfItNeeded() {
    if (elements.length == size) {
      Object[] newArray = new Object[newLength];
      System.arraycopy(elements, 0, newArray, 0, size);
      elements = newArray;
    }
  }

  @Override
  public void add(T value, int index) {
    Objects.checkIndex(index, size);
    resizeIfItNeeded();
    System.arraycopy(elements, index, elements, index + 1, size - index);
    elements[index] = elements;
    size++;
  }

  @Override
  public T get(int index) {
    Objects.checkIndex(index, size);
    return (T) elements[index];
  }

  @Override
  public void set(T value, int index) {
    Objects.checkIndex(index, size);
    elements[index] = value;
  }

  @Override
  public T remove(int index) {
    Objects.checkIndex(index, size);
    T removedValue = (T) elements[index];
    System.arraycopy(elements, index + 1, elements, index, size - index - 1);
    size--;
    return removedValue;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }
}
