package ru.job4j.problems;

/**
 * describes count.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 19.05.2017
 * @version 1.0
 */
public class PCounter {
    /**
     * count.
     */
    private long count;

    /**
     * constructor.
     */
    public PCounter() {
        this.count = 0;
    }

    /**
     * increases count.
     */
    public void increase() {
        this.count++;
    }

    /**
     * gets count.
     * @return - this.count
     */
    public long getCount() {
        return this.count;
    }
}
