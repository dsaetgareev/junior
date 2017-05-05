package ru.job4j.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * testing methods of class TreeNode.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 04.05.2017
 * @version 1.0
 */
public class TreeNodeTest {
    /**
     * testing method add.
     */
    @Test
    public void whenAddThenSizeAndBoolean() {
        TreeNode<Integer> treeNode = new TreeNode<>();

        assertThat(treeNode.add(10, 10), is(true));
        assertThat(treeNode.size(), is(1));

        assertThat(treeNode.add(10, 5), is(true));
        assertThat(treeNode.size(), is(2));
    }

    /**
     * testing method findParent().
     */
    @Test
    public void whenFindParentThenBoolean() {
        TreeNode<Integer> treeNode = new TreeNode<>();

        assertThat(treeNode.add(10, 10), is(true));
        assertThat(treeNode.size(), is(1));

        assertThat(treeNode.add(10, 5), is(true));
        assertThat(treeNode.size(), is(2));

        treeNode.add(10, 7);
        treeNode.add(10, 8);
        assertThat(treeNode.add(7, 1), is(true));

    }

    /**
     * testing method isBinary().
     */
    @Test
    public void whenIsBinaryThenBoolean() {
        TreeNode<Integer> treeNoBinary = new TreeNode<>();
        TreeNode<Integer> treeBinary = new TreeNode<>();

        treeNoBinary.add(10, 10);
        treeNoBinary.add(10, 4);
        treeNoBinary.add(10, 5);
        treeNoBinary.add(10, 6);
        treeNoBinary.add(5, 1);
        treeNoBinary.add(5, 2);
        treeNoBinary.add(5, 3);

        assertThat(treeNoBinary.isBinary(treeNoBinary.getParent()), is(false));

        treeBinary.add(10, 10);
        treeBinary.add(10, 4);
        treeBinary.add(10, 5);
        treeBinary.add(10, 6);
        treeBinary.add(5, 1);
        treeBinary.add(5, 2);

        assertThat(treeBinary.isBinary(treeBinary.getParent()), is(true));
    }

    /**
     * testing method getChildren().
     */
    @Test
    public void whenGetChildrenThenArrayList() {
        TreeNode<Integer> treeNoBinary = new TreeNode<>();

        treeNoBinary.add(10, 10);
        treeNoBinary.add(10, 4);
        treeNoBinary.add(10, 5);
        treeNoBinary.add(10, 6);
        treeNoBinary.add(5, 1);
        treeNoBinary.add(5, 2);
        treeNoBinary.add(5, 3);

        List<Integer> list = treeNoBinary.getChildren();
        List<Integer> afterList = new ArrayList<>();
        afterList.add(1);
        afterList.add(2);
        afterList.add(3);
        afterList.add(4);
        afterList.add(5);
        afterList.add(6);
        afterList.add(10);

        assertThat(list, is(afterList));

        System.out.println(list);
    }

    /**
     * testing method next().
     */
    @Test
    public void whenNextThenTreeNode() {
        TreeNode<Integer> treeNoBinary = new TreeNode<>();

        treeNoBinary.add(10, 10);
        treeNoBinary.add(10, 4);
        treeNoBinary.add(10, 5);
        treeNoBinary.add(10, 6);
        treeNoBinary.add(5, 1);
        treeNoBinary.add(5, 2);
        treeNoBinary.add(5, 3);

        List<Integer> list = treeNoBinary.getChildren();

        System.out.println(list);

        Iterator<Integer> iterator = treeNoBinary.iterator();

        iterator.next();
        iterator.next();
        assertThat(iterator.next(), is(3));
    }

    /**
     * testing method hashNext().
     */
    @Test
    public void whenHashNextThenBoolean() {
        TreeNode<Integer> treeNode = new TreeNode<>();

        treeNode.add(10, 10);
        treeNode.add(10, 5);
        treeNode.add(10, 6);

        Iterator<Integer> iter = treeNode.iterator();

        iter.next();
        assertThat(iter.hasNext(), is(true));

        iter.next();
        iter.next();

        assertThat(iter.hasNext(), is(false));
    }

}