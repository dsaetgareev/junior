package ru.job4j.comparable;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * class SortUser contains method sort(List<User> userList) return TreeSet<User>.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 02.04.2017
 * @version 1.0
 */
public class SortUser {
    /**
     * public Set<User> sort(List<User> userList).
     * @param userList - List to sort
     * @return result - TreeSet<User>
     */
    public Set<User> sort(List<User> userList) {
        Set<User> result = new TreeSet<>();
        for (User user : userList) {
            result.add(user);
        }
        return result;
    }
}
