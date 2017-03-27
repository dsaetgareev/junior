package ru.job4j.bank;

/**
 * class WorkingTime describes working time of a bank.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 24.03.2017
 */
public class WorkingTime {
    /**
     * count visitors.
     */
    private int count;
    /**
     * time.
     */
    private int time;

    /**
     * constructor WorkingTime.
     * @param count - int
     * @param time - int
     */
    public WorkingTime(int count, int time) {
        this.count = count;
        this.time = time;
    }

    /**
     * sets count.
     * @param count - int
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * gets count.
     * @return this.count - int
     */
    public int getCount() {
        return this.count;
    }

    /**
     * gets time.
     * @return this.time - int
     */
    public int getTime() {
        return this.time;
    }
}
