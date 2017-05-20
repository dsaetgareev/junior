package ru.job4j.problems;

/**
 * class shows the problems of multithreading.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 19.05.2017
 */
public class SeeProblems {
    /**
     * method main.
     *
     * @param args - String[] args
     * @throws InterruptedException - Exception
     */
    public static void main(String[] args) throws InterruptedException {
        PCounter counter = new PCounter();
        for (int j = 0; j < 10000; j++) {
            Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 3000; i++) {
                        counter.increase();
                    }
                }
            });
            th.start();
        }
        Thread.sleep(10000);
        System.out.println(counter.getCount());
    }
}
