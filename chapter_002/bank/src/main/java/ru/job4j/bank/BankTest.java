package ru.job4j.bank;

/**
 * class BankTest testing working time of a bank.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 24.03.2017
 */
public class BankTest {
    /**
     * method main.
     * @param args - String[].
     */
    public static void main(String[] args) {
        WorkingTime[] workingTimes = new WorkingTime[12];
        Man[] mans = new Man[5];
        Bank bank = new Bank(workingTimes, mans);
        bank.show();
    }
}
