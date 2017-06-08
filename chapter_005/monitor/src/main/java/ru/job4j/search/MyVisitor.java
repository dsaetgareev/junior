package ru.job4j.search;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * MyVisitor extends SimpleFileVisitor.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 04.06.2017
 */
public class MyVisitor extends SimpleFileVisitor {
    /**
     * input.
     */
    private String s;
    /**
     * boolean stop.
     */
    private boolean stop;

    /**
     * constructor.
     * @param s - string
     */
    public MyVisitor(String s) {
        this.s = s;
    }

    /**
     * visitor to file.
     * @param file - file
     * @param attrs - attrs
     * @return - fileVisitResult
     * @throws IOException - exception
     */
    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {

        FileVisitResult result;
       while (!stop) {
            if (this.s != null && ((Path) file).getFileName().toString().contains(this.s)) {
                System.out.println(Thread.currentThread().getName());
                System.out.println("I am walkVisitor, file: " + this.s + "  found!"
                        + "\nThe file is locate at: " + ((Path) file).getParent());
                this.stop = true;
                return FileVisitResult.TERMINATE;
            } else {
                //System.out.println("file: " + file);
                return FileVisitResult.CONTINUE;
            }
        }
        return FileVisitResult.TERMINATE;
    }
}
