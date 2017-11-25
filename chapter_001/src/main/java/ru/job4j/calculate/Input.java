package ru.job4j.calculate;

import java.util.Scanner;

/**
 * Created by dinis on 13.07.17.
 */
public class Input {

    private Scanner sc = new Scanner(System.in);

    public Input() {

    }

    public double ask(String question) {
        System.out.println(question);
        return Double.parseDouble(sc.nextLine());
    }

    public int answer(String question) {
        System.out.println(question);
        return Integer.valueOf(sc.nextLine());
    }
}
