package ru.job4j.lock;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dinis on 30.05.17.
 */
public class UserLockTest {

    @Test
    public void whenLockThenTime() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(i);
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        });
        UserLock userLock = new UserLock(thread);

        thread.start();
        userLock.lock();
        System.out.println("time of lock!");
        userLock.unlock();
    }

}