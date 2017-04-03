package ru.job4j.comparable;


import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;

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
        result.addAll(userList);
        return result;
    }

    /**
     * method sortHash(List<User> userList) sorts by hashCode userList.
     * @param userList - no sorted List
     * @return userList - sorted List
     */
    public List<User> sortHash(List<User> userList) {
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                int result = user1.hashCode() - user2.hashCode();
                if (result == 0) {
                    return 0;
                } else {
                    return result / Math.abs(result);
                }
            }
        });
        return userList;
    }

    /**
     * method sortLength(List<User> userList) sorts by name length userList.
     * @param userList - no sorted List
     * @return - userList - sorted List
     */
    public List<User> sortLength(List<User> userList) {
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                int result = user2.getName().length() - user1.getName().length();
                if (result == 0) {
                    return 0;
                } else {
                    return result / Math.abs(result);
                }
            }
        });
        return userList;
    }
}
