package ru.job4j.subdivision;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * class StructureTest tests methods of class Structure.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 06.04.2017
 * @version 1.0
 */
public class StructureTest {
    /**
     * testing compareTo of class Structure.
     */
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
        aStr.add(new Structure("K1"));
        aStr.add(new Structure("K1\\SK1"));
        aStr.add(new Structure("K1\\SK1\\SSK1"));
        aStr.add(new Structure("K1\\SK1\\SSK2"));
        aStr.add(new Structure("K1\\SK2"));
        aStr.add(new Structure("K2"));
        aStr.add(new Structure("K2\\SK1"));
        afterSort.trimToSize();
        aStr.trimToSize();
        assertThat(afterSort, is(aStr));
    }

    /**
     * testing method sortList() of class SortStructure.
     */
    @Test
    public void whenListSubDivisionThenSortedList() {
        SortStructure sortStructure = new SortStructure();
        TreeSet<Structure> str = new TreeSet<>();
        str.add(new Structure("K1\\SK1\\SSK2"));
        str.add(new Structure("K2"));
        str.add(new Structure("K2\\SK1"));
        str.add(new Structure("K1"));
        str.add(new Structure("K1\\SK2"));
        str.add(new Structure("K1\\SK1"));
        str.add(new Structure("K1\\SK1\\SSK1"));

        ArrayList<Structure> aStr = new ArrayList<>();
        aStr.add(new Structure("K2"));
        aStr.add(new Structure("K2\\SK1"));
        aStr.add(new Structure("K1"));
        aStr.add(new Structure("K1\\SK1"));
        aStr.add(new Structure("K1\\SK1\\SSK1"));
        aStr.add(new Structure("K1\\SK1\\SSK2"));
        aStr.add(new Structure("K1\\SK2"));
        ArrayList<Structure> afterList = new ArrayList<>(str);
        sortStructure.sortList(afterList);
        assertThat(afterList, is(aStr));
    }
}
