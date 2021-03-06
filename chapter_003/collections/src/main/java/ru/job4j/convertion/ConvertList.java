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

    /**
     * method convertIterator(List<int[]> list) converts List<int[]> list to List<Integer> listInteger.
     * @param list - List<int[]> list
     * @return result - List<Integer>
     */
    public List<Integer> convertIterator(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        Iterator<int[]> iterator = list.iterator();
        while (iterator.hasNext()) {
            int[] temp = iterator.next();
            for (int i = 0; i < temp.length; i++) {
                result.add(temp[i]);
            }
        }
        return result;
    }
    /**
     * method convert(List<int[]> list) converts List<int[]> list to List<Integer> listInteger.
     * @param list - List<int[]> list
     * @return result - List<Integer>
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array : list) {
            for (int value : array) {
                result.add(value);
            }
        }
        return result;
    }
}
