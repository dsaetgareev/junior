package ru.job4j.generic;

/**
 * class SimpleArray<T> implements a container.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 13.04.2017
 * @version 1.0
 * @param <T> - some type
 */
public class SimpleArray<T> {
    /**
     * array for objects.
     */
    private Object[] objects;
    /**
     * index of position.
     */
    private int index = 0;

    /**
     * constructor.
     * @param size - size of array.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * constructor.
     * @param objects - new objects
     */
    public SimpleArray(T[] objects) {
        this.objects = objects;
    }

    /**
     * add new element.
     * @param value - new element
     */
    public void add(T value) {
        this.objects[this.index++] = value;
    }

    /**
     * get position.
     * @param position - index position
     * @return - object
     */
    public T get(int position) {
        return (T) this.objects[position];
    }

    /**
     * edit array.
     * @param position - position of this.objects
     * @param value - new value
     */
    public void update(int position, T value) {
        this.objects[position] = value;
    }

    /**
     * remove by position.
     * @param position - position of this.objects
     */
    public void delete(int position) {
        int amountElement = this.objects.length - position - 1;
        System.arraycopy(this.objects, position + 1, this.objects, position, amountElement);
    }

    /**
     * remove by value.
     * @param value - value of this.objects
     */
    public void delete(T value) {
        for (int i = 0; i < this.objects.length; i++) {
            if (this.objects[i].equals(value)) {
                int amountElement = this.objects.length - i - 1;
                System.arraycopy(this.objects, i + 1, this.objects, i, amountElement);
            }
        }
    }
}
