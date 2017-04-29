package ru.job4j.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * container SimpleTree<E>.
 *
 * @param <E> - some type
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 29.04.2017
 */
public class SimpleTree<E> {
    /**
     * root entry.
     */
    private Entry<E> root;
    /**
     * size.
     */
    private int size = 0;
    /**
     * list of entry.
     */
    private List<Entry<E>> listEntry;

    /**
     * constructor.
     */
    public SimpleTree() {
        this.listEntry = new ArrayList<>();
    }

    /**
     * comparator.
     */
    private Comparator<? super E> comparator;

    /**
     * adds new element.
     *
     * @param value - new element
     */
    public void addChild(E value) {
        Entry<E> t = root;
        if (t == null) {
            t = new Entry<E>(value, null);
            root = t;
            listEntry.add(t);
            size++;
        } else {
            do {
                int i = compare(value, t.value);
                if (i < 0) {
                    if (t.left == null) {
                        t.left = new Entry<E>(value, t);
                        listEntry.add(t.left);
                        size++;
                        break;
                    }
                    t = t.left;
                }
                if (i > 0) {
                    if (t.right == null) {
                        t.right = new Entry<E>(value, t);
                        listEntry.add(t.right);
                        size++;
                        break;
                    }
                    t = t.right;
                }
                if (i == 0) {
                    t.setValue(value);
                    break;
                }
            } while (true);
        }
    }

    /**
     * gets all children.
     *
     * @return - List<E> listValue
     */
    public List<E> getChildren() {
        List<E> listValue = new ArrayList<E>();
        for (int i = 0; i < this.listEntry.size(); i++) {
            listValue.add(listEntry.get(i).getValue());

        }
        listValue.sort(new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return ((Comparable<? super E>) o1).compareTo((E) o2);
            }
        });
        return listValue;
    }

    /**
     * search element.
     * @param value - value
     * @return - boolean
     */
    public boolean searchElem(E value) {
        boolean result = false;
        for (Entry<E> eEntry : this.listEntry) {
            if (eEntry != null && eEntry.getValue().equals(value)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * return size.
     *
     * @return - this.size
     */
    public int size() {
        return this.size;
    }

    /**
     * checks balance.
     * @return - boolean
     */
    public boolean checkBalance() {
        boolean result = true;
        for (Entry<E> eEntry : this.listEntry) {
            if (eEntry.left == null && eEntry.right != null || eEntry.left != null && eEntry.right == null) {
                result = false;
            }
        }
        return result;
    }

    /**
     * binary search element.
     * @param value - value
     * @return - boolean
     */
    public boolean searchBinary(E value) {
        boolean result = false;
        Entry<E> t = root;
        do {
            int i = compare(t.getValue(), value);
            if (i == 0) {
                result = true;
                break;
            }
            if (i < 0) {
                t = t.left;
            }
            if (i > 0) {
                t = t.right;
            }

        } while (t != null);
        return result;
    }

    /**
     * compare for comparator.
     *
     * @param e1 - 1 element
     * @param e2 - 2 element
     * @return int
     */
    @SuppressWarnings("unchecked")
    private int compare(Object e1, Object e2) {
        return comparator == null ? ((Comparable<? super E>) e1).compareTo((E) e2)
                : comparator.compare((E) e1, (E) e2);
    }

    /**
     * class Entry<E>.
     *
     * @param <E> - elemtnt
     */
    public class Entry<E> {
        /**
         * value.
         */
        private E value;
        /**
         * parent element.
         */
        private Entry<E> parent;
        /**
         * left element.
         */
        private Entry<E> left;
        /**
         * right element.
         */
        private Entry<E> right;

        /**
         * constructor.
         *
         * @param value  - new value
         * @param parent - new parent
         */
        public Entry(E value, Entry<E> parent) {
            this.value = value;
            this.parent = parent;
        }

        /**
         * get value.
         *
         * @return value
         */
        public E getValue() {
            return this.value;
        }

        /**
         * sets value.
         *
         * @param value - value
         */
        public void setValue(E value) {
            this.value = value;
        }
    }
}
