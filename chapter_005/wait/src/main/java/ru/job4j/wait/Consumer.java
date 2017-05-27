package ru.job4j.wait;

/**
 * Consumer implements Runnable gets element.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 28.05.2017
 * @version 1.0
 */
public class Consumer implements Runnable {
    /**
     * buffer.
     */
    private Buffer buffer;

    /**
     * constructor.
     * @param buffer - new buffer
     */
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    /**
     * method run() gets value.
     */
    @Override
    public void run() {
        while (true) {
            try {
                Integer value = buffer.get();
                System.out.println(value + " Gets value!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
