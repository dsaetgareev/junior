package ru.job4j.wait;

/**
 * Producer implements Runnable create new element.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 28.05.2017
 * @version 1.0
 */
public class Producer implements Runnable {
    /**
     * buffer.
     */
    private Buffer buffer;

    /**
     * constructor.
     * @param buffer - new buffer
     */
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    /**
     * method run() crate value.
     */
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(this.buffer.put() + " Create value!");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
