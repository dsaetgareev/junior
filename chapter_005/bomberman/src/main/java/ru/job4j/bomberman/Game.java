package ru.job4j.bomberman;

import javax.swing.JPanel;

/**
 * Game..
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 19.06.2017
 * @version 1.0
 */
public class Game extends JPanel {
    /**
     * method main.
     * @param args - String[]
     */
    public static void main(String[] args) {
        BoardGraph bg = new BoardGraph();
            bg.init();
    }
}
