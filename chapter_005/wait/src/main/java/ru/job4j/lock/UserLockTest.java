package ru.job4j.lock;

/**
 * testing of the class UserLock.
 */
public class UserLockTest {
    /**
     * method main.
     * @param arRgs - String[]
     * @throws InterruptedException - exception
     */
    public static void main(String[] arRgs) throws InterruptedException {

        UserLock userLock = new UserLock();

        Thread threadLock = new Thread(new Block(userLock));
        Thread threadUnlock = new Thread(new UnBlock(userLock));

        threadLock.start();
        threadUnlock.start();

        Thread.sleep(5000);

        userLock.lock();

        Thread.sleep(3000);

        userLock.unblock();
        Thread.sleep(5000);
        threadLock.interrupt();
        threadUnlock.interrupt();
    }
}
