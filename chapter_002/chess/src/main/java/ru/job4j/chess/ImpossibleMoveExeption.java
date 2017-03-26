package ru.job4j.chess;

/**
 * ImpossibleMoveException extends Exception - if not correct specified a cell.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 24.03.2017
 */
class ImpossibleMoveException extends Exception {
    /**
     * Constructor ImpossibleMoveException().
     */
    ImpossibleMoveException() {
        System.out.println("This figure can not so walk!!");
    }
}
