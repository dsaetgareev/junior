package ru.job4j.lock;

/**
 * UserLock.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 30.05.2017
 * @version 1.0
 */
public class UserLock {
    /**
     * boolean check.
     */
    private boolean check;
    /**
     * boolean block.
     */
    private boolean block;

    /**
     * constructor.
     */
    public UserLock() {

    }

    /**
     * gets check.
     * @return this. check
     */
    public boolean getCheck() {
        return this.check;
    }

    /**
     * gets block.
     * @return this.block
     */
    public boolean getBlock() {
        return this.block;
    }

    /**
     * lock thread.
     */
    public synchronized void lock() {
        if (this.check) {
            try {
                this.wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println("lock");
        this.check = true;
        this.notifyAll();
    }

    /**
     * unlock thread.
     */
    public synchronized void unlock() {
        if (!this.check) {
            try {

                this.wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        this.check = false;
        System.out.println("unlock");
        this.notifyAll();

    }

    /**
     * revers block.
     */
    public void unblock() {
        this.block = !this.block;
    }
}
