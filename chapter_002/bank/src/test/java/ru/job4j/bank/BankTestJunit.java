package ru.job4j.bank;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class BankTest testing working time of a bank.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 24.03.2017
 */
public class BankTestJunit {
    /**
     * void whenFlowPeopleThenWorkingTime().
     */
    @Test
    public void whenFlowPeopleThenWorkingTime() {
        WorkingTime[] workingTimes = new WorkingTime[] {new WorkingTime(0, 8),
        new WorkingTime(0, 9)};
        Man[] mans = new Man[] {new Man(8, 10)};
        Bank bank = new Bank(workingTimes, mans);
        bank.flowPeople();
        assertThat(bank.flowPeople()[0].getCount(), is(1));
    }
    /**
     * void whenMaxFlowThenWorkingTime().
     */
    @Test
    public void whenMaxFlowThenWorkingTime() {
        WorkingTime[] workingTimes = new WorkingTime[]{new WorkingTime(0, 8),
                new WorkingTime(0, 9)};
        Man[] mans = new Man[]{new Man(8, 10)};
        Bank bank = new Bank(workingTimes, mans);
        bank.maxFlow();
        assertThat(bank.maxFlow()[0].getCount(), is(1));
    }
}
