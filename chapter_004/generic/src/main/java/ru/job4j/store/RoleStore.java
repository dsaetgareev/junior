package ru.job4j.store;

import ru.job4j.generic.SimpleArray;

import java.util.Iterator;
import java.util.Random;

/**
 *class RoleStore implements Store<T>.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 13.04.2017
 */
public class RoleStore implements Store<Role> {
    /**
     * database for role.
     */
    private SimpleArray<Role> roleStore = new SimpleArray<>(10);
    /**
     * rn - random value.
     */
    private Random rn = new Random();

    /**
     * adds new Role.
     * @param role - new role
     */
    public void add(Role role) {
        role.setId(String.valueOf(rn.nextInt(1000)));
        this.roleStore.add(role);
    }

    /**
     * edit a role.
     * @param role - role of which is update
     */
    public void edit(Role role) {
        for (int i = 0; i < this.roleStore.size(); i++) {
            if (this.roleStore.get(i) != null && this.roleStore.get(i).getId().equals(role.getId())) {
                this.roleStore.update(i, role);
            }
        }
    }

    /**
     * remove a role.
     * @param role - remove of which is remove
     */
    public void remove(Role role) {
        for (int i = 0; i < this.roleStore.size(); i++) {
            if (this.roleStore.get(i) != null && this.roleStore.get(i).getId().equals(role.getId())) {
                this.roleStore.delete(role);
            }
        }
    }
    /**
     * return all element roleStore.
     * @return all element
     */
    public SimpleArray<Role> findAll() {
        SimpleArray<Role> result = new SimpleArray<>(this.roleStore.size());
        Iterator<Role> iterator = this.roleStore.iteratorSimple();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }

}
