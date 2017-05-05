package ru.job4j.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * class TreeNode<E extends Comparable<E>> implements NewSimpleTree<E>,
 * container.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 04.05.2017
 * @version 1.0
 * @param <E> some type
 */
public class TreeNode<E extends Comparable<E>> implements NewSimpleTree<E> {
    /**
     * parent node.
     */
    private Node<E> parent;
    /**
     * size.
     */
    private int size;

    /**
     * constructor.
     */
    public TreeNode() {
        this.parent = new Node<>(null);
        this.size = 0;
    }

    /**
     * gets parent.
     * @return this.parent
     */
    public Node<E> getParent() {
        return this.parent;
    }

    /**
     * iterator for size.
     */
    public void sizeIter() {
        this.size++;
    }

    /**
     * adds element child to parent.
     *
     * @param parent - parent
     * @param value  - new value
     * @return boolean
     */
    @Override
    public boolean add(E parent, E value) {
        boolean result = false;
        if (this.parent.value == null) {
            this.parent.value = value;
            this.size++;
            result = true;
        } else {
            if (compare(this.parent.value, parent) == 0) {
                this.parent.children.add(new Node<E>(value));
                this.size++;
                result = true;
            } else {
                Node<E> node = findParent(parent, this.parent);
                if (node != null) {
                    node.children.add(new Node<E>(value));
                    this.size++;
                    result = true;
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

    /**
     * search node by value.
     *
     * @param value  - value
     * @param parent - parent
     * @return node
     */
    public Node<E> findParent(E value, Node<E> parent) {
        Node<E> result = null;
        for (Node<E> node : parent.children) {
            if (node.children.size() > 0) {
                findParent(value, node);
            }
            if (compare(node.value, value) == 0) {
                result = node;
                break;
            }
        }
        return result;
    }

    /**
     * checking is binary.
     * @param parent parent
     * @return boolean
     */
    public boolean isBinary(Node<E> parent) {
        boolean result = true;
        for (Node<E> node : parent.children) {
            if (node.children.size() > 2) {
                result = false;
                break;
            }
            if (node.children.size() > 0) {
                isBinary(node);
            }
        }
        return result;
    }

    /**
     * returns all value.
     * @return list
     */
    public List<E> getChildren() {
        List<E> list = new ArrayList<E>();
        listChildren(list, parent);
        list.add(0, parent.value);
        list.sort(new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return o1.compareTo(o2);
            }
        });
        return list;
    }

    /**
     * create list of children.
     * @param parent - parent
     * @param list - list
     */
    public void listChildren(List<E> list, Node<E> parent) {
        for (Node<E> node : parent.children) {
            if (node.children.size() > 0) {
                listChildren(list, node);
            }
            list.add(node.value);
        }
    }

    /**
     * return this.size.
     *
     * @return this.size
     */
    public int size() {
        return this.size;
    }

    /**
     * compare().
     *
     * @param o1 - element
     * @param o2 - element
     * @return int
     */
    public int compare(E o1, E o2) {
        return o1.compareTo(o2);
    }

    /**
     * iterator().
     * @return TreeIterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new TreeIterator();
    }

    /**
     * class TreeIterator.
     */
    class TreeIterator implements Iterator<E> {
        /**
         * cursor for iterator.
         */
        private int cursor = 0;

        /**
         * hashNext().
         * @return boolean
         */
        public boolean hasNext() {
            return size > this.cursor;
        }

        /**
         * next().
         * @return next element
         */
        public E next() {
            return getChildren().get(cursor++);
        }

    }

    /**
     * class Node, describes node.
     * @param <E> - some type
     */
    class Node<E extends Comparable<E>> {
        /**
         * value.
         */
        private E value;
        /**
         * list children.
         */
        private List<Node<E>> children;

        /**
         * constructor.
         * @param value - new value
         */
        Node(E value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        /**
         * gets value.
         * @return this.value
         */
        public E getValue() {
            return (E) this.value;
        }

        /**
         * gets children.
         * @return this.children
         *
         */
        public List<Node<E>> getChildren() {
            return this.children;
        }

        /**
         * sets value.
         * @param value - new value
         */
        public void setValue(E value) {
            this.value = value;
        }
    }
}
