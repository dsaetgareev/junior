package ru.job4j.tree;

import java.util.Comparator;

/**
 * class TreeNodeBinary<E extends Comparable<E>> extends TreeNode<E>,
 * binary container.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 04.05.2017
 * @version 1.0
 * @param <E> - some type
 */
public class TreeNodeBinary<E extends Comparable<E>> extends TreeNode<E> {
    /**
     * constructor.
     */
    public TreeNodeBinary() {
        super();
    }

    /**
     * adds new element.
     * @param value - new value
     * @return boolean
     */
    public boolean add(E value) {
        boolean result = false;
        if (super.size() == 0) {
            super.getParent().setValue(value);
            super.sizeIter();
            result = true;
        } else {

            Node<E> node = searchCell(value, super.getParent());
            if (value.compareTo(node.getValue()) == -1) {
                if (!containsValue(value, node)) {
                    node.getChildren().add(new Node<E>(value));
                    super.sizeIter();
                    result = true;
                }
            }
            if (value.compareTo(node.getValue()) == 1) {
                if (!containsValue(value, node)) {
                    node.getChildren().add(new Node<E>(value));
                    super.sizeIter();
                    result = true;
                }
            }
            node.getChildren().sort(new Comparator<Node<E>>() {
                @Override
                public int compare(Node<E> o1, Node<E> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });
        }

        return result;
    }

    /**
     * searches cell node.
     * @param value - cell value
     * @param parent - parent node
     * @return cell node
     */
    public Node<E> searchCell(E value, Node<E> parent) {
        Node<E> result = null;
        if (value.compareTo(parent.getValue()) == -1) {
            if (parent.getChildren().size() == 2) {
                parent = parent.getChildren().get(0);
                searchCell(value, parent);
            }
            result = parent;
        }
        if (value.compareTo(parent.getValue()) == 1) {
            if (parent.getChildren().size() == 2) {
                parent = parent.getChildren().get(1);
                searchCell(value, parent);
            }
            result = parent;
        }
        return result;
    }

    /**
     * checking contains list children element value.
     * @param value - value
     * @param parent - parent node
     * @return boolean
     */
    public boolean containsValue(E value, Node<E> parent) {
        boolean result = false;
        for (Node<E> node : parent.getChildren()) {
            if (value.compareTo(node.getValue()) == 0) {
                result = true;
                break;
            }
        }
        return result;
    }
}
