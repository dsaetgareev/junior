package ru.job4j.simplemap;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * testing methods of class SimpleMap.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 26.04.2017
 * @version 1.0
 */
public class SimpleMapTest {
    /**
     * testing method insert().
     * @throws Exception - exception
     */
    @Test
    public void whenInsertThenSimpleMapSize() throws Exception {
        SimpleMap<String, String> map = new SimpleMap<>();

        map.insert("first", "first");
        map.insert("second", "second");

        assertThat(map.size(), is(2));

        map.insert("first", "first");

        assertThat(map.size(), is(2));

        map.insert("second", "test");
        map.toShow();
        assertThat(map.size(), is(2));
        assertThat(map.get("second"), is("test"));

    }

    /**
     * testing method add.
     * @throws Exception - exception
     */
    @Test
    public void whenAddThenArrayLength() throws Exception {
        SimpleMap<String, String> map = new SimpleMap<>();
        SimpleMap<String, String>.Node<String, String>[] nodes = new SimpleMap.Node[10];

        map.add(nodes, "name", "test");
        int count = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null) {
                count++;
            }
        }
        assertThat(map.size(), is(1));
        assertThat(count, is(1));
    }

    /**
     * testing method increaseArray().
     * @throws Exception - exception
     */
    @Test
    public void whenIncreaseArrayThenSize() throws Exception {
        SimpleMap<String, String> map = new SimpleMap<>();
        for (int i = 0; i < 9; i++) {
            map.insert("a" + i, "b" + i + 1);
        }

        assertThat(map.size(), is(9));

        for (int i = 9; i < 50; i++) {
            map.insert("a" + i, "b" + i + 1);
        }

        map.toShow();
        assertThat(map.size(), is(50));
    }

    /**
     * testing method get().
     * @throws Exception - exception
     */
    @Test
    public void whenInsertThenGet() throws Exception {
        SimpleMap<String, String> map = new SimpleMap<>();
        for (int i = 0; i < 9; i++) {
            map.insert("a" + i, "b" + i + 1);
        }
        for (int i = 9; i < 50; i++) {
            map.insert("a" + i, "b" + i + 1);
        }

        assertThat(map.get("a30"), is("b301"));

    }

    /**
     * testing method delete().
     * @throws Exception - exception
     */
    @Test
    public void whenDeleteThenSize() throws Exception {
        SimpleMap<String, String> map = new SimpleMap<>();
        for (int i = 0; i < 9; i++) {
            map.insert("a" + i, "b" + i + 1);
        }
        for (int i = 9; i < 50; i++) {
            map.insert("a" + i, "b" + i + 1);
        }
        assertThat(map.delete("a30"), is(true));

        assertThat(map.size(), is(49));
    }

    /**
     * testing method hasNext().
     */
    @Test
    public void whenHasNextThenBoolean() {
        SimpleMap<String, String> map = new SimpleMap<>();
        for (int i = 0; i < 9; i++) {
            map.insert("a" + i, "b" + i + 1);
        }
        for (int i = 9; i < 50; i++) {
            map.insert("a" + i, "b" + i + 1);
        }
        Iterator<SimpleMap<String, String>.Node<String, String>> iterator = map.iterator();
        iterator.next();
        assertThat(iterator.hasNext(), is(true));

        for (int i = 0; i < map.size() - 2; i++) {
            iterator.next();
        }
        assertThat(iterator.hasNext(), is(true));

        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * testing method next().
     */
    @Test
    public void whenIteratorNextThenMapGet() {
        SimpleMap<String, String> map = new SimpleMap<>();
        for (int i = 0; i < 9; i++) {
            map.insert("a" + i, "b" + i + 1);
        }
        for (int i = 9; i < 50; i++) {
            map.insert("a" + i, "b" + i + 1);
        }

        Iterator<SimpleMap<String, String>.Node<String, String>> iterator = map.iterator();
        for (int i = 0; i < 4; i++) {
            iterator.next();
        }

        assertThat(iterator.next().getValue(), is("b141"));

        assertThat(iterator.next().getValue(), is("b301"));
    }
}