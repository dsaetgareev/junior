package ru.job4j.simplearrayset;

import java.util.Random;

/**
 * insertion speed testing.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 20.04.2017
 * @version 1.0
 */
public class SetsTest {
    /**
     * fills set.
     * @param set - some set
     */
    public static void fillSet(SimpleArraySet set) {
        Random rn = new Random();
        for (int i = 0; i < 10000; i++) {
            int ran = rn.nextInt();
            set.add(ran);
        }
    }

    /**
     * returns time adding.
     * @param set - set
     * @return - time
     */
    public static long add(SimpleArraySet set) {
        long startTime = System.currentTimeMillis();
        fillSet(set);
        return System.currentTimeMillis() - startTime;
    }

    /**
     * method main.
     * @param args - String[]
     */
    public static void main(String[] args) {
        SimpleArraySet<Integer> simpleSet = new SimpleArraySet<>();

        QuickSet<Integer> quickSet = new QuickSet<>();

        System.out.println("SimpleArraySet = " + SetsTest.add(simpleSet) + "ms");

        System.out.println("QuickSet = " + SetsTest.add(quickSet) + "ms");
    }

}
