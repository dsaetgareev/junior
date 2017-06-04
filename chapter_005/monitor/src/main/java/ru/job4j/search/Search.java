package ru.job4j.search;

import java.io.File;

/**
 * fail search.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 04.06.2017
 * @version 1.0
 */
public class Search {
    /**
     * name of file.
     */
    private String s;
    /**
     * boolean for stop.
     */
    private boolean stop;

    /**
     * constructor.
     * @param s - name of file
     */
    public Search(String s) {
        this.s = s;
    }

    /**
     * walks through the file tree.
     * @param root - file
     */
    public void walk(File root) {
        if (!stop) {
            if (root.isFile()) {
                if (root.isFile() && root.getName().equals(this.s)) {
                    this.stop = true;
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("file " + this.s + " found!\nThe file is locate at: " + root.getAbsolutePath());
                }
            } else {
                File[] files = root.listFiles();
                if (files != null) {
                    for (File doc : files) {
                        walk(doc);
                    }
                }
           }
        }
    }
}
