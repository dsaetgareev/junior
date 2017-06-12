package ru.job4j.search;

import java.util.Scanner;

/**
 * testing of class Search.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 04.06.2017
 * @version 1.0
 */
public class SearchTest {
    /**
     * method main.
     * @param args - String[]
     */
    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        Search search = new Search(s);


        //new Thread(new Searching(search, false)).start();
        new Thread(new Searching(search, true)).start();


    }
}
