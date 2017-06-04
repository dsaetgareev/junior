package ru.job4j.lock;

/**
 * work and blocking thread.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 30.05.2017
 * @version 1.0
 */
public class Block implements Runnable {
    /**
     * UserLock.
     */
    private UserLock userLock;
    /**
     * count.
     */
    private int count = 0;

    /**
     * constructor.
     * @param userLock - UserLock
     */
    public Block(UserLock userLock) {
        this.userLock = userLock;
    }

    /**
     * method run().
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            while (!Thread.currentThread().isInterrupted() && !this.userLock.getCheck()) {
                System.out.println(this.count++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    System.out.println("finish");
                    throw new RuntimeException();
                }
            }
        }
    }
}
