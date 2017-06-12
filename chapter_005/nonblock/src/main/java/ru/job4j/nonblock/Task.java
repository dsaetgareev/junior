package ru.job4j.nonblock;

/**
 * describes task.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 12.06.2017
 */
public class Task {
    /**
     * id.
     */
    private int id;
    /**
     * name of task.
     */
    private String name;
    /**
     * version of task.
     */
    private volatile int version = 1;

    /**
     * constructor.
     * @param id - id
     * @param name - name
     */
    public Task(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * gets id.
     * @return this.id
     */
    public int getId() {
        return this.id;
    }

    /**
     * gets name.
     * @return - this.name
     */
    public String getName() {
        return this.name;
    }

    /**
     * sets id.
     * @param id - new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * gets version.
     * @return - this.version
     */
    public int getVersion() {
        return this.version;
    }

    /**
     * increments version.
     */
    public void versionInc() {
        this.version++;
    }
}
