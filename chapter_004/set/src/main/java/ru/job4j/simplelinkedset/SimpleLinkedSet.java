package ru.job4j.simplelinkedset;


import java.util.Iterator;

/**
 * container SimpleLinkedSet<E>.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 19.04.2017
 * @version 1.0
 * @param <E> - some type
 */
public class SimpleLinkedSet<E> {
    /**
     * size of container.
     */
    private int size = 0;
    /**
     * first node.
     */
    private Node<E> first;

    /**
     * default container.
     */
    public SimpleLinkedSet() {

    }

    /**
     * adds new element.
     * @param e new item
     */
    public void add(E e) {
        if (this.size == 0) {
            this.first = new Node<>(e, null);
            this.size++;
        } else {
            if (hasDuplicate(e)) {
                Node<E> first = this.first;
                for (int i = 0; i < size - 1; i++) {
                    first = first.next;
                }
                first.next = new Node<>(e, null);
                this.size++;
            }
        }
    }

    /**
     * checks for availability duplicates.
     * @param e checked item
     * @return boolean
     */
    public boolean hasDuplicate(E e) {
        int count = 0;
        if (!e.equals(this.first.value)) {
            Node<E> temp = this.first;
            for (int i = 0; i < size - 1; i++) {
                temp = temp.next;
                if (e.equals(temp.value)) {
                    count++;
                }
            }
        }
        return count == 0 ? true : false;
    }

    /**
     * return size.
     * @return this.size
     */
    public int size() {
        return this.size;
    }

    /**
     * iterator().
     * @return Iterator<E>
     */
    public Iterator<E> iterator() {
        return new SimpleLinkedSetIterator();
    }
    /**
     * create iterator.
     */
    private class SimpleLinkedSetIterator implements Iterator<E> {
        /**
         * cursor.
         */
        private int cursor = 0;
        /**
         * checks for the next element.
         *
         * @return - boolean
         */
        public boolean hasNext() {
            return size > this.cursor;
        }
        /**
         * return next element.
         *
         * @return - return next element
         */
        public E next() {
            Node<E> temp = null;
            if (first != null) {
                temp = first;
                for (int i = 0; i < size - 1; i++) {
                    temp = temp.next;
                }
            }
            this.cursor++;
            return temp.value;
        }
    }

    /**
     * class Node implements node.
     * @param <E> some type
     */
    private class Node<E> {
        /**
         * value.
         */
        private E value;
        /**
         * next node.
         */
        private Node<E> next;

        /**
         * constructor.
         * @param value - new value
         * @param next - next node
         */
        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
