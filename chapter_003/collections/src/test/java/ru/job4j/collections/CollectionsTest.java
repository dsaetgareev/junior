package ru.job4j.collections;


import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * this program tests the time adding and removing collections.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 29.03.2017
 */
public class CollectionsTest {


    /**
     * method main tests collections.
     *
     * @param args - String[]
     */
    public static void main(String[] args) {
        Collection<String> arrayList = new ArrayList<>();
        Collection<String> linkedList = new LinkedList<>();
        Collection<String> treeSet = new TreeSet<>();
        ArrayList<String> arrayListForDelete = new ArrayList<>();

        CollectionInterface collectionInterface = new CollectionInterface();

        long arrayListTime = collectionInterface.add(arrayList, "test", 1000000);
        System.out.println("Time addition of ArrayList: " + arrayListTime + "ms");
        long linkedListTime = collectionInterface.add(linkedList, "test", 1000000);
        System.out.println("Time addition of LinkedList: " + linkedListTime + "ms");
        long treeSetTime = collectionInterface.add(treeSet, "test", 1000000);
        System.out.println("Time addition of TreeSet: " + treeSetTime + "ms");

        long arrayListTimeDelete = collectionInterface.delete(arrayList, 10000);
        System.out.println("Time removal of ArrayList: " + arrayListTimeDelete + "ms");
        long linkedListTimeDelete = collectionInterface.delete(linkedList, 10000);
        System.out.println("Time removal of LinkedList: " + linkedListTimeDelete + "ms");
        long treeSetTimeDelete = collectionInterface.delete(treeSet, 10000);
        System.out.println("Time removal of TreeSet: " + treeSetTimeDelete + "ms");
        System.out.println();
        long arrayListTimeDeleteEnd = collectionInterface.delete(10000, arrayListForDelete);
        System.out.println("Time removal of ArrayList from the end: " + arrayListTimeDeleteEnd + "ms");
    }

}
