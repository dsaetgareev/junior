package ru.job4j.bank;

/**
 * class Man describes time a man when he is in the bank.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 24.03.2017
 */
public class Man {
    /**
     * entry time.
     */
    private int entryTime;
    /**
     * exit time.
     */
    private int exitTime;

    /**
     * Constructor Man.
     * @param entryTime - int
     * @param exitTime - int
     */
    public Man(int entryTime, int exitTime) {
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    /**
     * creates array time.
     * @return array - int
     */
    public int[] timeInTheBank() {
        int rang = exitTime - entryTime;
        int[] result = new int[rang];
        for (int i = 0; i < rang; i++) {
            result[i] = entryTime + i;
        }
        return result;
    }
}
