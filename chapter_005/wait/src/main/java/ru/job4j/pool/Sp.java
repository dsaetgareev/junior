package ru.job4j.pool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * calculate date of exit to work.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 28.05.2017
 * @version 1.0
 */
public class Sp {
    /**
     * method main.
     * @param args - String[]
     * @throws ParseException - exception
     */
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Calendar cal = new GregorianCalendar();
        System.out.println("Enter date to holiday: ");
        cal.setTime(format.parse(new Scanner(System.in).nextLine()));
        System.out.println("Enter amount days: ");
        int count = new Scanner(System.in).nextInt();
        Work work = new Work(cal, count);
        work.calculateDate2();
    }
}
