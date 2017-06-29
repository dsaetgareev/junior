package ru.job4j.bomberman;

/**
 * MonsterThread.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 19.06.2017
 * @version 1.0
 */
public class MonstersThread implements Runnable {
    /**
     * monster.
     */
    private Monster monster;

    /**
     * constructor.
     * @param monster - monster
     */
    public MonstersThread(Monster monster) {
        this.monster = monster;
    }

    /**
     * run().
     */
    @Override
    public void run() {
        monster.move();
    }
}
