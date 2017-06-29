package ru.job4j.bomberman;

/**
 * HeroThread.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 19.06.2017
 * @version 1.0
 */
public class HeroThread implements Runnable {
    /**
     * hero.
     */
    private Hero hero;
    /**
     * key.
     */
    private int key;

    /**
     * constructor.
     * @param hero - hero
     * @param key - key
     */
    public  HeroThread(Hero hero, int key) {
        this.hero = hero;
        this.key = key;
    }

    /**
     * run().
     */
    @Override
    public void run() {
        this.hero.move(this.key);
    }
}
