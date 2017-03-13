package ru.job4j.task31;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class DoctorTest checking methods class Doctor.
 */
public class DoctorTest {
    /**
     * method void whenHealThenHealth().
     */
    @Test
    public void whenHealThenHealth() {
        Professional prof = new Teacher("Den", 30, "engineer", 10, 20, 30, 40);
        Doctor doc = new Doctor("Alan", 29, "teacher", 30, 40, 50, 60);
        doc.heal(prof);
        assertThat(prof.getHealth(), is(30));
    }
}
