package ru.job4j.subdivision;

import java.util.*;

/**
 * Created by dinis on 05.04.17.
 */
public class Structure implements Comparable<Structure> {
    private String subdivision;

    public Structure(String subdivision) {
        this.subdivision = subdivision;
    }
    public String getSubdivision() {
        return this.subdivision;
    }

    @Override
    public String toString() {
        return "Structure{subdivision='" + subdivision + '\'' +'}';
    }
    public int compareTo(Structure structure) {
       return  this.getSubdivision().compareTo(structure.getSubdivision());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Structure structure = (Structure) o;

        return subdivision != null ? subdivision.equals(structure.subdivision) : structure.subdivision == null;
    }

    @Override
    public int hashCode() {
        return subdivision != null ? subdivision.hashCode() : 0;
    }

    public static void main(String[] args) {
        ArrayList<Structure> str = new ArrayList<>();
        str.add(new Structure("K1\\SK1\\SSK2"));
        str.add(new Structure("K2"));
        str.add(new Structure("K2\\SK1"));
        str.add(new Structure("K1"));
        str.add(new Structure("K1\\SK2"));
        str.add(new Structure("K1\\SK1"));
        str.add(new Structure("K1\\SK1\\SSK1"));
        TreeSet<Structure> ts = new TreeSet<>(str);

        for (Structure struc : ts) {
            System.out.println(struc);
        }
    }
}
