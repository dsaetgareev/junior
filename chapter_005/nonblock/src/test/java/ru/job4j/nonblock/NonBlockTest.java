package ru.job4j.nonblock;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * testing methods of class NonBlock.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 12.06.2017
 */
public class NonBlockTest {
    /**
     * task.
     */
    private Task task;
    /**
     * cache NonBlock.
     */
    private NonBlock cache;

    /**
     * creates model.
     */
    @Before
    public void model() {
        this.cache = new NonBlock();
        this.task = new Task(1, "test");
    }

    /**
     * testing method add(Task task).
     */
    @Test
    public void whenAddsTaskThenCacheSize() {

        this.cache.add(this.task);

        assertThat(this.cache.cacheSize(), is(1));
    }

    /**
     * updates cache.
     */
    @Test
    public void whenUpdateTaskThenNewTask() {
        this.cache.add(this.task);

        assertThat(this.cache.update(this.task.getId(), new Task(0, "test2")).getName(),
                is("test2"));
    }

    /**
     * removes task.
     */
    @Test
    public void whenDeleteThenNull() {

        this.cache.add(this.task);

        assertThat(this.cache.cacheSize(), is(1));

        this.cache.delete(1);

        assertThat(this.cache.cacheSize(), is(0));
    }
}