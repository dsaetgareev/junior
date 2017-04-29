package ru.job4j.tree;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * tests methods of SimpleTree.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 29.04.2017
 * @version 1.0
 */
public class SimpleTreeTest {
    /**
     * testing method addChild(E value).
     */
    @Test
    public void whenAddThenSize() {
        SimpleTree<String> tree = new SimpleTree<>();
        tree.addChild("j");
        tree.addChild("b");
        tree.addChild("l");

        assertThat(tree.size(), is(3));

        for (String value : tree.getChildren()) {
            System.out.println(value);
        }
    }

    /**
     * testing method searchElement(E value).
     */
    @Test
    public void whenSearchElementThenBoolean() {
        SimpleTree<String> tree = new SimpleTree<>();
        tree.addChild("j");
        tree.addChild("b");
        tree.addChild("l");

        assertThat(tree.size(), is(3));

        assertThat(tree.searchElem("l"), is(true));

        assertThat(tree.searchElem("u"), is(false));
    }

    /**
     * testing method checkBalance().
     */
    @Test
    public void whenCheckBalanceThen() {
        SimpleTree<String> tree = new SimpleTree<>();
        tree.addChild("j");
        tree.addChild("b");
        tree.addChild("l");

        assertThat(tree.checkBalance(), is(true));

        tree.addChild("u");

        assertThat(tree.checkBalance(), is(false));
    }

    /**
     * testing method searchBinary(E value).
     */
    @Test
    public void whenSearchBinaryThenBoolean() {
        SimpleTree<String> tree = new SimpleTree<>();
        tree.addChild("j");
        tree.addChild("b");
        tree.addChild("l");
        tree.addChild("a");
        tree.addChild("w");
        tree.addChild("k");

        assertThat(tree.searchElem("w"), is(true));

        assertThat(tree.searchElem("p"), is(false));
    }

    /**
     * testing speed of searchElement() and searchBinary().
     */
    @Test
    public void whenSearchBinaryAndConsistentlyThenSpeed() {
        SimpleTree<Integer> tree = new SimpleTree<>();
        Random rn = new Random();

        tree.addChild(567123489);
        for (int i = 0; i < 1000000; i++) {
            tree.addChild(rn.nextInt());
        }

        long startTimeConsistently = System.currentTimeMillis();
        assertThat(tree.searchElem(567123489), is(true));
        long resultSearchConsistently =  System.currentTimeMillis() - startTimeConsistently;

        long startTimeBinary = System.currentTimeMillis();
        assertThat(tree.searchBinary(567123489), is(true));
        long resultSearchBinary =  System.currentTimeMillis() - startTimeBinary;

        System.out.println(resultSearchConsistently);
        System.out.println(resultSearchBinary);

    }
}