package ru.job4j.simplestack;

import ru.job4j.simplelinkedlist.SimpleLinkedList;

/**
 * container SimpleStack<E> implements Stack, the last one came, out first.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 16.04.2017
 * @version 1.0
 * @param <E> - type.
 */
public class SimpleStack<E> {
    /**
     * container SimpleLinkedList.
     */
    private SimpleLinkedList<E> queues = new SimpleLinkedList<E>();
    /**
     * size.
     */
    private int size = 0;

    /**
     * default constructor.
     */
    public SimpleStack() {

    }
    /**
     * adds new element, adds to the end of the list.
     * @param e - new element
     */
    public void push(E e) {
        this.queues.add(e);
        this.size++;
    }

    /**
     * remove first element.
     */
    public void poll() {
        if (this.size != 0 && this.queues.get(size - 1) != null) {
            this.queues.remove(size - 1);
            this.size--;
        }
    }

    /**
     * returns first element.
     * @return first element
     */
    public E getFirst() {
        return this.queues.get(0);
    }

    /**
     * returns last element.
     * @return last element
     */
    public E getLast() {
        return this.queues.get(size - 1);
    }

    /**
     * return size.
     * @return size
     */
    public int size() {
        return this.size;
    }
}
