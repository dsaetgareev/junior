package ru.job4j.monitor;


/**
 * class Count demonstrates multithreading.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 21.05.2017
 * @version 1.0
 */
public class Count {
    /**
     * count.
     */
    private int count;

    /**
     * constructor.
     */
    public Count() {
        this.count = 0;
    }

    /**
     * gets count.
     * @return this.count
     */
    public int getCount() {
        return this.count;
    }

    /**
     * increments count.
     * @return this.count++
     */
    public synchronized int increment() {
        return this.count++;
    }

    /**
     * main.
     * @param args - String[]
     * @throws InterruptedException - Exception.
     */
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        Thread thread1 = new CountThread(count);
        Thread thread2 = new CountThread(count);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(count.getCount());
    }

}
