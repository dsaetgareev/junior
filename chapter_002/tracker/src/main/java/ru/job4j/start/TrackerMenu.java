package ru.job4j.start;

/**
 * interface TrackerMenu.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 17.03.2017
 * @version 1.0
 */
public interface TrackerMenu {
    /**
     * void descriptionTracker().
     */
    void descriptionTracker();
    /**
     * void fillAction().
     */
    void fillAction();

    /**
     * void show().
     */
    void show();

    /**
     * void select(int key).
     * @param key - int
     */
    void select(int key);
}
