package ru.job4j.threads;

import java.util.Scanner;

/**
 * describes different threads.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 17.05.2017
 */
public class Counter {
    /**
     * method main.
     *
     * @param args - String[]
     */
    public static void main(String[] args) throws InterruptedException {

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
        System.out.println("This program counts words and spaces.");
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        thread1.interrupt();
        thread2.interrupt();
        thread1.join();
        thread2.join();
        System.out.println("End. Text processed.");
    }
}
