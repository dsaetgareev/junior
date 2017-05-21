package ru.job4j.monitor;

/**
 * CountThread extends Thread.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 21.05.2017
 * @version 1.0
 */
public class CountThread extends Thread {
    /**
     * instance Count.
     */
    private final Count count;

    /**
     * constructor.
     * @param count - new Count
     */
    public CountThread(final Count count) {
        this.count = count;
    }

    /**
     * method run().
     */
    @Override
    public void run() {
        this.count.increment();
    }
}
