package ru.job4j.task31;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class ProfessionalTest checking methods class Professional.
 */
public class ProfessionalTest {
    /**
     * whenSalaryThenAdditionalSalary().
     */
    @Test
    public void whenSalaryThenAdditionalSalary() {
        Professional prof = new Professional("Den", 30, "engineer", 10, 20, 30, 40);
        prof.additional(10);
        int sal = prof.getSalary();
        assertThat(sal, is(20));
    }

    /**
     * method whenSetHealthThenHealth().
     */
    @Test
    public void whenSetHealthThenHealth() {
        Professional prof = new Professional("Den", 30, "engineer", 10, 20, 30, 40);
        prof.setHealth(30);
        assertThat(prof.getHealth(), is(30));
    }
    /**
     * method whenSetEducationThenEducation().
     */
    @Test
    public void whenSetEducationThenEducation() {
        Professional prof = new Professional("Den", 30, "engineer", 10, 20, 30, 40);
        prof.setEducation(40);
        assertThat(prof.getEducation(), is(40));
    }
    /**
     * method whenSetComfortThenComfort().
     */
    @Test
    public void whenSetComfortThenComfort() {
        Professional prof = new Professional("Den", 30, "engineer", 10, 20, 30, 40);
        prof.setComfort(50);
        assertThat(prof.getComfort(), is(50));
    }
}