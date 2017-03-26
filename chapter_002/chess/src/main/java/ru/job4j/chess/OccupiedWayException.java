package ru.job4j.chess;

/**
 * OccupiedWayException extends Exception - Occupied way.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 24.03.2017
 */
class OccupiedWayException extends Exception {
    /**
     * Constructor OccupiedWayException().
     */
    OccupiedWayException() {
        System.out.println("Occupied way!!!");
    }
}
