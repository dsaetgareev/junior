package ru.job4j.threads;

import java.util.Scanner;

/**
 * describes different threads.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 17.05.2017
 * @version 1.0
 */
public class Counter {
    /**
     * method main.
     * @param args - String[]
     */
    public static void main(String[] args) {

        String s = new Scanner(System.in).nextLine();

        Tokenizer tokenizer = new Tokenizer(s);


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Total of words = " + tokenizer.countWord());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Total of spaces = " + tokenizer.countSpaces());
            }
        });

        thread1.start();
        thread2.start();
    }
}
