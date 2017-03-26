package ru.job4j.chess;

/**
 * FigureNotFoundException extends Exception - looking a figure.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 24.03.2017
 */
public class FigureNotFoundException extends Exception {
    /**
     * Constructor FigureNotFoundException().
     */
    FigureNotFoundException() {
        System.out.println("In the cell no find a figure!!!");
    }
}
