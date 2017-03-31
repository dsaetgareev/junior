package ru.job4j.user;

import java.util.HashMap;
import java.util.List;

/**
 * class UserConvert contains method HashMap<Integer, User> process(List<User> list)
 * that converting List<User> list to HashMap<Integer, User>.
 * @param id - id of User
 * @param name - name of User
 * @param city - city of User
 */
public class UserConvert {
    /**
     * method HashMap<Integer, User> process(List<User> list) - converting List<User> list to HashMap<Integer, User>.
     * @param list - List<User>
     * @return map - HashMap<Integer, User>
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User user : list) {
            map.put(user.getId(), user);
        }
        return map;
    }
}
