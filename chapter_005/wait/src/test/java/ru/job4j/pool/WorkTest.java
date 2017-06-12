package ru.job4j.pool;

import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * testing methods of class Work.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 28.05.2017
 * @version 1.0
 */
public class WorkTest {
    /**
     * testing method calculateDate2().
     * @throws ParseException - exception
     */
    @Test
    public void whenDateThenDayToWork() throws ParseException {
        Work work = new Work(new GregorianCalendar(2017, 05, 05), 13);

        Calendar dayToWork = new GregorianCalendar(2017, 05, 19);

        assertThat(work.calculateDate2(), is(dayToWork));

    }

    /**
     * testing method countHolidayInRang().
     */
    @Test
    public void whenHolidaysThenCount() {
        Work work = new Work(new GregorianCalendar(2017, 05, 05), 13);

        Calendar dayToWork = new GregorianCalendar(2017, 05, 20);

        assertThat(work.countHolidayInRang(new GregorianCalendar(2017, 05, 05), dayToWork),
                is(1));
    }

}