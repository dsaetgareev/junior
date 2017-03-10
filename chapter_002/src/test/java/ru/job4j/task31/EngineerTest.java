package ru.job4j.task31;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class EngineerTest checking methods class Engineer.
 */
public class EngineerTest {
    /**
     * method void whenConstructorThenComfort().
     */
    @Test
    public void whenConstructorThenComfort() {
        Professional prof = new Professional("Den", 30, "engineer", 10, 20, 30, 40);
        Engineer eng = new Engineer("Alan", 29, "teacher", 30, 40, 50, 60);
        eng.constructor(prof);
        assertThat(prof.getComfort(), is(50));
    }
}
