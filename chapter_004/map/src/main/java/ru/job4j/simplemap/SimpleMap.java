package ru.job4j.simplemap;


import java.util.Iterator;

/**
 * class SimpleMap.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 26.04.2017
 * @version 1.0
 * @param <K> - key
 * @param <V> - value
 */
public class SimpleMap<K, V> {
    /**
     * array of node.
     */
    private Node<K, V>[] objects;
    /**
     * size.
     */
    private int size;
    /**
     *
     */
    private int lengthForArray = 10;

    /**
     * constructor.
     */
    public SimpleMap() {
    this.objects = new Node[this.lengthForArray];
    this.size = 0;
}
    /**
     * adds new element in this.objects.
     * @param key - new key
     * @param value - new value
     * @return boolean
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        if (!hasDuplicate(key, value)) {
            add(this.objects, key, value);
            increaseArray();
            result = true;
        }
        return result;
    }

    /**
     * adds new element.
     * @param array - Node[]
     * @param key - new element
     * @param value - new value
     */
    public void add(Node<K, V>[] array, K key, V value) {
        Node<K, V> newNode = new Node<>(key, value, null);
        int index = cellNumber(key);
        Node<K, V> node = array[index];
        if (hasCollision(node, key)) {
            Node<K, V> x = node;
            while (x.next != null) {
                x = x.next;
                if (x.getKey().equals(key)) {
                    x.setValue(value);
                    newNode = null;
                    this.size--;
                    break;
                }
            }
            x.next = newNode;
            this.size++;
        } else {
            newNode.next = null;
            if (array[index] != null && array[index].getKey().equals(key)) {
                this.size--;
            }
            array[index] = newNode;
            this.size++;
        }
    }

    /**
     * increase this.objects.
     */
    public void increaseArray() {
        int oldLength = this.objects.length;
        if (this.size == oldLength) {
            this.lengthForArray = (int) (this.objects.length * 1.5 + 1);
            this.size = 0;
            Node<K, V>[] newObjects = new Node[this.lengthForArray];
            for (int i = 0; i < this.objects.length; i++) {
                if (this.objects[i] != null) {
                    Node<K, V> x = this.objects[i];
                    while (x != null) {
                        add(newObjects, x.getKey(), x.getValue());
                        x = x.next;
                    }
                }
            }
            this.objects = newObjects;
        }
    }

    /**
     * checking for collision.
     * @param node - node
     * @param key  - key
     * @return - boolean
     */
    public boolean hasCollision(Node<K, V> node, K key) {
        return node != null && !node.getKey().equals(key);
    }

    /**
     * checking for duplicates.
     * @param key - key
     * @param value - value
     * @return - boolean
     */
    public boolean hasDuplicate(K key, V value) {
        boolean result = false;
        Node<K, V> node = this.objects[cellNumber(key)];
        while (node != null) {
            if (node.getKey().equals(key) && node.getValue().equals(value)) {
                result = true;
                break;
            }
            node = node.next;
        }
        return result;
    }

    /**
     * return number of cell.
     * @param key - key
     * @return - number
     */
    public int cellNumber(K key) {
        int hash = key.hashCode();
        return hash % this.lengthForArray;
    }

    /**
     * gets value.
     * @param key - key
     * @return value
     */
    public V get(K key) {
        V value = null;
        int index = cellNumber(key);
        Node<K, V> node = this.objects[index];
        while (node != null) {
            if (node.getKey().equals(key)) {
                value = node.getValue();
                break;
            }
            node = node.next;
        }
        return value;
    }

    /**
     * deletes element.
     * @param key - key of element
     * @return boolean
     */
    public boolean delete(K key) {
        boolean result = false;
        int index = cellNumber(key);
        Node<K, V> prev = this.objects[index];
        Node<K, V> e = prev;
        while (e != null) {
            Node<K, V> next = e.next;
            if (e.getKey() == key || key != null && e.getKey().equals(key)) {
                this.size--;
                if (prev == e) {
                    this.objects[index] = next;
                } else {
                    prev.next = next;
                    result = true;
                    break;
                }
            }
            prev = e;
            e = next;
        }
        return result;
    }

    /**
     * shows all element.
     */
    public void toShow() {
        for (Node<K, V> node : this.objects) {
            if (node != null) {
                System.out.println(node.getKey() + " = " + node.getValue());
                Node<K, V> next = node.next;
                while (next != null) {
                    System.out.println(next.getKey() + " = " + next.getValue());
                    next = next.next;
                }
            }
        }
    }

    /**
     * return this.size.
     * @return size
     */
    public int size() {
        return this.size;
    }

    /**
     * iterator().
     * @return Iterator<Node<K, V>>
     */
    public Iterator<Node<K, V>> iterator() {
        return new MapIterator();
    }

    /**
     * class MapIterator.
     */
    private class MapIterator implements Iterator<Node<K, V>> {
        /**
         * cursor.
         */
        private int cursor = 0;
        /**
         * position of array.
         */
        private int position = 0;
        /**
         * count for collision.
         */
        private int countForCollision = 0;

        /**
         * checks for the next element.
         *
         * @return - boolean
         */
        public boolean hasNext() {
            return size > cursor;
        }
        /**
         * return next element.
         *
         * @return - return next element
         */
        public Node<K, V> next() {
            Node<K, V> node = null;
            while (cursor < size) {
                Node<K, V> next = objects[this.position];
                if (next != null) {
                    for (int i = 0; i < countForCollision; i++) {
                        next = next.next;
                    }
                    countForCollision++;
                    cursor++;
                    if (next.next == null) {
                        countForCollision = 0;
                        position++;
                    }
                    node = next;
                    break;
                }
                this.position++;
            }
            return node;
        }
    }

    /**
     * class Node<K, V>.
     * @param <K> - key
     * @param <V> - value
     */
    public class Node<K, V> {
        /**
         * key.
         */
        private K key;
        /**
         * value.
         */
        private V value;
        /**
         * next.
         */
         private Node<K, V> next;

        /**
         * constructor.
         * @param key - new key
         * @param value - new value
         * @param next - new next
         */
        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * gets key.
         * @return this.key
         */
        public K getKey() {
            return this.key;
        }

        /**
         * gets value.
         * @return this.value
         */
        public V getValue() {
            return value;
        }

        /**
         * sets value.
         * @param newValue - new value
         * @return - old value
         */
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        /**
         * equals().
         * @param o - another object
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

            Node<?, ?> node = (Node<?, ?>) o;

            if (key != null ? !key.equals(node.key) : node.key != null) {
                return false;
            }
            return value != null ? value.equals(node.value) : node.value == null;
        }

        /**
         * hashCode().
         * @return hash
         */
        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }

        /**
         * toString().
         * @return - string
         */
        @Override
        public String toString() {
            return this.key + " = " + this.value;
        }
    }
}
