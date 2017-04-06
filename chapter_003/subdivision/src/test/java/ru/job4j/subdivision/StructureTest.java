package ru.job4j.subdivision;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by dinis on 06.04.17.
 */
public class StructureTest {
    @Test
    public void whenSubdivisionThenStructure() {

        TreeSet<Structure> str = new TreeSet<>();
        str.add(new Structure("K1\\SK1\\SSK2"));
        str.add(new Structure("K2"));
        str.add(new Structure("K2\\SK1"));
        str.add(new Structure("K1"));
        str.add(new Structure("K1\\SK2"));
        str.add(new Structure("K1\\SK1"));
        str.add(new Structure("K1\\SK1\\SSK1"));
        ArrayList<Structure> afterSort = new ArrayList<>(str);
        ArrayList<Structure> aStr = new ArrayList<>();
        str.add(new Structure("K1"));
        str.add(new Structure("K1\\SK1"));
        str.add(new Structure("K1\\SK1\\SSK1"));
        str.add(new Structure("K1\\SK1\\SSK2"));
        str.add(new Structure("K1\\SK2"));
        str.add(new Structure("K2"));
        str.add(new Structure("K2\\SK1"));
        afterSort.trimToSize();
        aStr.trimToSize();
        assertThat(afterSort, is(aStr));
    }
}
