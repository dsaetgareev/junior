package ru.job4j.convertion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * class ConvertList contains methods that converts a collections to an array
 * and an array to a collections.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 29.03.2017
 */
public class ConvertList {
    /**
     * converts array to collections.
     * @param array - array
     * @return arrayList - List<E>
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> arrayList = new ArrayList<>();
        for (int[] arrays : array) {
            for (int arr : arrays) {
                arrayList.add(arr);
            }
        }
        return arrayList;
    }

    /**
     * method converts collection to array.
     * @param list - collection
     * @param rows - int
     * @return array - array
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int rows1 = 0;
        if (list.size() % rows != 0) {
            rows1 = list.size() / rows + 1;
        } else {
            rows1 = list.size() / rows;
        }
        int[][] array = new int[rows1][rows];
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < rows && iterator.hasNext(); j++) {
               array[i][j] = iterator.next();
            }
        }

        return array;
    }
}
