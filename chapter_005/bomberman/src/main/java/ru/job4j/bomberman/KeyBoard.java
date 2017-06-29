package ru.job4j.bomberman;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.ExecutorService;


/**
 * KeyBoard.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 19.06.2017
 */
public class KeyBoard extends KeyAdapter {
    /**
     * hero.
     */
    private Hero hero;
    /**
     * ExecutorService.
     */
    private ExecutorService service;

    /**
     * constructor.
     *
     * @param hero    - hero
     * @param service - service
     */
    public KeyBoard(Hero hero, ExecutorService service) {
        this.hero = hero;
        this.service = service;
    }

    /**
     * keyPressed.
     *
     * @param event - KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        service.submit(new HeroThread(this.hero, key));
    }
}
