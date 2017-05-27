package ru.job4j.wait;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * testing methods of class Buffer.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 28.05.2017
 * @version 1.0
 */
public class BufferTest {
    /**
     * testing methods put() and get().
     * @throws InterruptedException - Exception
     */
    @Test
    public void whenPutThenGet() throws InterruptedException {
        Buffer buffer = new Buffer();

        assertThat(buffer.put(), is(buffer.get()));
    }

}