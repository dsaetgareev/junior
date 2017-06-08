package ru.job4j.search;

import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;


/**
 * fail search.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 04.06.2017
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
     *
     * @param s - name of file
     */
    public Search(String s) {
        this.s = s;
    }

    /**
     * walks through the file tree.
     *
     * @param root - file
     */
    public void walkRecur(File root) {
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

                                    walkRecur(doc);

                    }
                }
            }

        }
    }

    /**
     * gets exception.
     * @param path - path
     * @param visitor - visitor
     */
    public void walkFile(Path path, MyVisitor visitor) {
        try {
            Files.walkFileTree(path, visitor);
        } catch (AccessDeniedException ae) {
            System.out.println("Read Only: " + path + " " + Thread.currentThread().getName());
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    /**
     * walkVisitor the file system.
     * @param root - root file
     * @throws IOException - exception
     */
    public void walkVisitor(File root) throws IOException {

        MyVisitor visitor = new MyVisitor(this.s);
        File[] files = root.listFiles();
        if (files != null) {
            for (File file : files) {
                Path path = file.toPath();
                new Thread(() ->
                        walkFile(path, visitor)
                ).start();
            }
        }
    }
}
