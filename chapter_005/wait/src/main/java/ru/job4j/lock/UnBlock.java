package ru.job4j.lock;

/**
 * unlock thread.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 30.05.2017
 * @version 1.0
 */
public class UnBlock implements Runnable {
    /**
     * UserLock.
     */
    private UserLock userLock;

    /**
     * constructor.
     * @param userLock - UserLock
     */
    public UnBlock(UserLock userLock) {
        this.userLock = userLock;
    }

    /**
     * method run().
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (this.userLock.getBlock()) {
                this.userLock.unlock();
                this.userLock.unblock();
            }
        }
    }
}
