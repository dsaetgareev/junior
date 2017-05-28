package ru.job4j.pool;

import java.text.ParseException;

/**
 * ConsumerWork implements Runnable gets work.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 28.05.2017
 * @version 1.0
 */
public class ConsumerWork implements Runnable {
    /**
     * buffer.
     */
    private BufferWork bufferWork = new BufferWork();

    /**
     * constructor.
     * @param bufferWork - new buffer
     */
    public ConsumerWork(BufferWork bufferWork) {
        this.bufferWork = bufferWork;
    }

    /**
     * method run() - gets next Work.
     */
    @Override
    public void run() {
        while (true) {
            try {
                this.bufferWork.get().calculateDate2();
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        }
    }
}
