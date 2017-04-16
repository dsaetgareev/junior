package ru.job4j.store;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * tests methods class UserStore.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 13.04.2017
 */
public class RoleStoreTest {
    /**
     * testing method add().
     */
    @Test
    public void whenAddThenRoleStore() {
        RoleStore roleStore = new RoleStore();
        Role role = new Role(null);

        roleStore.add(role);

        Role role2 = new Role(role.getId());

        assertThat(roleStore.findAll().get(0), is(role2));
    }

    /**
     * testing method update().
     */
    @Test
    public void whenUpdateThenRoleStore() {
        RoleStore roleStore = new RoleStore();
        Role role = new Role(null);

        roleStore.add(role);

        Role role2 = new Role(role.getId());
        Role role3 = new Role(role2.getId());

        assertThat(roleStore.findAll().get(0), is(role3));
    }
    /**
     * testing method remove().
     */
    @Test
    public void whenRemoveThenRoleStore() {
        RoleStore roleStore = new RoleStore();
        Role role = new Role(null);

        roleStore.add(role);

        assertThat(roleStore.findAll().size(), is(1));

        Role role1 = new Role(role.getId());

        roleStore.remove(role1);

        assertThat(roleStore.findAll().size(), is(0));
    }
}
