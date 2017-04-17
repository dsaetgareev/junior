package ru.job4j.cycle;


/**
 * container CycleList<T> implements cycle list.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 17.04.2017
 * @version 1.0
 * @param <T> - some type
 */
public class CycleList<T> {
    /**
     * first node.
     */
    private Node<T> first;
    /**
     * size.
     */
    private int size = 0;

    /**
     * adds new element.
     * @param t - new element
     */
    public void add(T t) {
        if (this.first == null) {
            this.first = new Node<T>(t);
        } else {
            Node<T> x = this.first;
            for (int i = 0; i < this.size - 1; i++) {
                x = x.next;
            }
            Node<T> newNode = new Node<T>(t);
            x.next = newNode;
            newNode.next = this.first;
        }
        size++;
    }

    /**
     * return size.
     * @return size
     */
    public int size() {
        return this.size;
    }

    /**
     * returns boolean for cycle.
     * @return boolean
     */
    public boolean hasCycle() {
        boolean result = false;
        Node<T> first = this.first.next;
        for (int i = 0; i < size - 1; i++) {
            first = first.next;
            if (first.equals(this.first)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * class implements node.
     * @param <T> - some type
     */
    private class Node<T> {
        /**
         * T value.
         */
        private T value;
        /**
         * next node.
         */
        private Node<T> next;

        /**
         * constructor.
         * @param value - new value
         */
        Node(T value) {
            this.value = value;
        }

        /**
         * equals().
         * @param o - other object
         * @return boolean
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Node<?> node = (Node<?>) o;

            if (value != null ? !value.equals(node.value) : node.value != null) {
                return false;
            }
            return next != null ? next.equals(node.next) : node.next == null;
        }

        /**
         * hasCode().
         * @return hasCode
         */
        @Override
        public int hashCode() {
            int result = value != null ? value.hashCode() : 0;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }
    }

}
