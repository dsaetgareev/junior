package ru.job4j.wait;

import java.util.Random;

/**
 * buffer.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 28.05.2017
 * @version 1.0
 */
public class Buffer {
    /**
     * value.
     */
    private Integer value;

    /**
     * constructor.
     */
    public Buffer() {

    }

    /**
     * create new element.
     * @return - element
     * @throws InterruptedException - Exception
     */
    public synchronized Integer put() throws InterruptedException {
        while (this.value != null) {
            this.wait();
        }
        this.value = new Random().nextInt(100);
        this.notifyAll();
        return this.value;
    }

    /**
     * return element.
     * @return - element
     * @throws InterruptedException - Exception
     */
    public synchronized Integer get() throws InterruptedException {
        Integer result;
        while (this.value == null) {
            this.wait();
        }
        result = this.value;
        this.value = null;
        this.notifyAll();
        return result;
    }
}
