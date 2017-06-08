package ru.job4j.search;

import java.io.File;
import java.io.IOException;

/**
 * Searching implements Runnable.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 04.06.2017
 */
public class Searching implements Runnable {
    /**
     * Search.
     */
    private Search search;
    /**
     * select.
     */
    private boolean select;

    /**
     * constructor.
     *
     * @param search - Search
     * @param select - boolean
     */
    public Searching(Search search, boolean select) {
        this.search = search;
        this.select = select;
    }

    /**
     * method run().
     */
    @Override
    public void run() {

        File root = new File("/");
        if (!select) {
            File[] files = root.listFiles();
            if (files != null) {
                for (File file : files) {
                    new Thread(() ->
                            this.search.walkRecur(file)).start();
                }
            }
        } else {
            try {
                this.search.walkVisitor(root);
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
    }
}
