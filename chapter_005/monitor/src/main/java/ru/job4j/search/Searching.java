package ru.job4j.search;

import java.io.File;

/**
 * Searching implements Runnable.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 04.06.2017
 * @version 1.0
 */
public class Searching implements Runnable {
    /**
     * Search.
     */
    private Search search;

    /**
     * constructor.
     * @param search - Search
     */
    public Searching(Search search) {
        this.search = search;
    }

    /**
     * method run().
     */
    @Override
    public void run() {
            this.search.walk(new File("/home"));
    }
}
