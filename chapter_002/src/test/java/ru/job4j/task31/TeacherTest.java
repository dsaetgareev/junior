package ru.job4j.task31;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class TeacherTest checking methods class Teacher.
 */

public class TeacherTest {
    /**
     * method void whenLearnThenEducation().
     */
    @Test
    public void whenLearnThenEducation() {
        Professional prof = new Professional("Den", 30, "engineer", 10, 20, 30, 40);
        Teacher teacher = new Teacher("Alan", 29, "teacher", 30, 40, 50, 60);
        teacher.learn(prof);
        assertThat(prof.getEducation(), is(40));
    }
}
