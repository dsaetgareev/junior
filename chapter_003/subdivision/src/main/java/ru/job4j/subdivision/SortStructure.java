package ru.job4j.subdivision;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * sorts natural order class Structure.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 06.04.2017
 * @version 1.0
 */
public class SortStructure {
    /**
     * sorts natural order.
     * @param list - List
     * @return sorted list
     */
    public List<Structure> sortList(List<Structure> list) {
        Collections.sort(list, new Comparator<Structure>() {
            @Override
            public int compare(Structure o1, Structure o2) {
                String k1;
                String k2;

                if (o1.getSubdivision().contains("\\")) {
                    k1 = o1.getSubdivision().substring(0, o1.getSubdivision().indexOf("\\"));
                } else {
                    k1 = o1.getSubdivision();
                }
                if (o2.getSubdivision().contains("\\")) {
                    k2 = o2.getSubdivision().substring(0, o2.getSubdivision().indexOf("\\"));
                } else {
                    k2 = o2.getSubdivision();
                }

                int j = k2.compareTo(k1);

                return j;
            }
        });
        return list;
    }
}
