package ru.job4j.pool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Carries out the work on the withdrawal of the employee on leave.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 28.05.2017
 * @version 1.0
 */
public class Work {
    /**
     * Holiday start date.
     */
    private Calendar calendar;
    /**
     * holidays.
     */
    private ArrayList<GregorianCalendar> holidays = new ArrayList<>();

    /**
     * constructor.
     * @param calendar - new calendar
     */
    public Work(Calendar calendar) {
        this.calendar = calendar;
    }

    /**
     * calculates date start of work.
     * @return date start of work
     * @throws ParseException - exception
     */
    public Calendar calculateDate2() throws ParseException {
            int count;
        System.out.println(Thread.currentThread().getName());
            Calendar newCalendar = (Calendar) this.calendar.clone();
            newCalendar.add(Calendar.DAY_OF_YEAR, 14);
            count = countHolidayInRang(this.calendar, newCalendar);
            if (count != 0) {
                newCalendar.add(Calendar.DAY_OF_YEAR, count);
            }
            System.out.println("Дата выхода на работу: " + newCalendar.getTime() + "\n");
            return newCalendar;
    }

    /**
     * fills holidays.
     */
    public void fillHolidays() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(format.parse("1.01.2017"));
            this.holidays.add(cal);
            GregorianCalendar cal2 = new GregorianCalendar();
            cal2.setTime(format.parse("2.01.2017"));
            this.holidays.add(cal2);
            GregorianCalendar cal3 = new GregorianCalendar();
            cal3.setTime(format.parse("3.01.2017"));
            this.holidays.add(cal3);
            GregorianCalendar cal4 = new GregorianCalendar();
            cal4.setTime(format.parse("4.01.2017"));
            this.holidays.add(cal4);
            GregorianCalendar cal5 = new GregorianCalendar();
            cal5.setTime(format.parse("5.01.2017"));
            this.holidays.add(cal5);
            GregorianCalendar cal6 = new GregorianCalendar();
            cal6.setTime(format.parse("6.01.2017"));
            this.holidays.add(cal6);
            GregorianCalendar cal7 = new GregorianCalendar();
            cal7.setTime(format.parse("7.01.2017"));
            this.holidays.add(cal7);
            GregorianCalendar cal8 = new GregorianCalendar();
            cal8.setTime(format.parse("8.01.2017"));
            this.holidays.add(cal8);
            GregorianCalendar cal9 = new GregorianCalendar();
            cal9.setTime(format.parse("23.02.2017"));
            this.holidays.add(cal9);
            GregorianCalendar cal10 = new GregorianCalendar();
            cal10.setTime(format.parse("8.03.2017"));
            this.holidays.add(cal10);
            GregorianCalendar cal11 = new GregorianCalendar();
            cal11.setTime(format.parse("1.05.2017"));
            this.holidays.add(cal11);
            GregorianCalendar cal12 = new GregorianCalendar();
            cal12.setTime(format.parse("1.09.2017"));
            this.holidays.add(cal12);
            GregorianCalendar cal13 = new GregorianCalendar();
            cal13.setTime(format.parse("12.06.2017"));
            this.holidays.add(cal13);
            GregorianCalendar cal14 = new GregorianCalendar();
            cal14.setTime(format.parse("25.06.2017"));
            this.holidays.add(cal14);
            GregorianCalendar cal15 = new GregorianCalendar();
            cal15.setTime(format.parse("11.10.2017"));
            this.holidays.add(cal15);
            GregorianCalendar cal16 = new GregorianCalendar();
            cal16.setTime(format.parse("4.11.2017"));
            this.holidays.add(cal16);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * counts holidays.
     * @param start - holiday start date
     * @param end - holiday end date
     * @return count
     */
    public synchronized int countHolidayInRang(Calendar start, Calendar end) {
        int count = 0;
        fillHolidays();
        for (Calendar data : this.holidays) {
            if (data.after(start) && data.before(end)) {
                count++;
            }
        }
        System.out.println("Количество праздинчных дней в отпуске: " + count);
        return count;
    }
}
