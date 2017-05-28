package ru.job4j.pool;

import java.util.ArrayList;


/**
 * buffer.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 28.05.2017
 * @version 1.0
 */
public class BufferWork {
    /**
     * container for works.
     */
    private ArrayList<Work> works = new ArrayList<>(10);

    /**
     * constructor.
     */
    public BufferWork() {

    }

    /**
     * adds new work.
     * @param work - new work
     */
    public synchronized void add(Work work) {
        try {
            if (this.works.size() == 10) {
                this.wait();
            }
            this.works.add(work);
            this.notifyAll();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * gets work.
     * @return work
     */
    public synchronized Work get() {
        try {
            if (this.works.size() == 0) {
                this.wait();
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        Work result = this.works.get(0);
        this.works.remove(0);
        this.notifyAll();
        return result;

    }
}
