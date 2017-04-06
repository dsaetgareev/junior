package ru.job4j.banking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * class BankTransactionTest tests methods of class BankTransaction.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 02.04.2017
 * @version 1.0
 */
public class BankTransactionTest {
    /**
     * testing method addUser(User user).
     */
    @Test
    public void whenAddUserThenDataBase() {
        Map<User, List<Account>> database = new HashMap<>();
        BankTransaction bt = new BankTransaction(database);
        User user = new User("A", "8007 345 654");
        bt.addUser(user);
        assertThat(database.size(), is(1));
    }

    /**
     * testing method deleteUser(User user).
     */
    @Test
    public void whenDeleteUserThenDataBase() {
        Map<User, List<Account>> database = new HashMap<>();
        BankTransaction bt = new BankTransaction(database);
        User user = new User("A", "8007 345 654");
        User user1 = new User("A", "8007 345 654");
        database.put(user, new ArrayList<>());
        assertThat(database.size(), is(1));
        bt.deleteUser(user1);
        assertThat(database.size(), is(0));
    }

    /**
     * testing method addAccountToUser().
     */
    @Test
    public void whenAddAccountToUserThenDatabase() {
        Map<User, List<Account>> database = new HashMap<>();
        BankTransaction bt = new BankTransaction(database);
        User user1 = new User("A", "8007 345 654");
        User user2 = new User("B", "8007 325 694");
        Account account = new Account(10000, "4276 0600 3435 6634");
        database.put(user1, new ArrayList<>());
        database.put(user2, new ArrayList<>());
        assertThat(database.size(), is(2));
        bt.addAccountToUser(user1, account);
        assertThat(database.get(user1).size(), is(1));
    }
    /**
     *testing method deleteAccountFromUser().
     */
    @Test
    public void whenDeleteAccountFromUserThenDatabase() {
        Map<User, List<Account>> database = new HashMap<>();
        BankTransaction bt = new BankTransaction(database);
        User user1 = new User("A", "8007 345 654");
        User user2 = new User("B", "8007 325 694");
        Account account = new Account(10000, "4276 0600 3435 6634");
        Account account1 = new Account(10000, "4276 0600 3435 6634");
        ArrayList<Account> arrayList = new ArrayList<>();
        arrayList.add(account);
        database.put(user1, arrayList);
        database.put(user2, new ArrayList<>());
        assertThat(database.size(), is(2));
        bt.deleteAccountFromUser(user1, account1);
        assertThat(database.get(user1).size(), is(0));
    }
    /**
     * testing method getUserAccounts().
     */
    @Test
    public void whenGetUserAccountsThenDatabase() {
        Map<User, List<Account>> database = new HashMap<>();
        BankTransaction bt = new BankTransaction(database);
        User user1 = new User("A", "8007 345 654");
        User user2 = new User("B", "8007 325 694");
        Account account = new Account(10000, "4276 0600 3435 6634");
        ArrayList<Account> arrayList = new ArrayList<>();
        arrayList.add(account);
        database.put(user1, arrayList);
        database.put(user2, new ArrayList<>());
        assertThat(bt.getUserAccounts(user1), is(arrayList));
    }
    /**
     * testing method transferMoney(User srcUser, Account srcAccount, User dstUser,
     * Account dstAccount, double amount).
     */
    @Test
    public void whenTransferMoneyThenDatabase() {
        Map<User, List<Account>> database = new HashMap<>();
        BankTransaction bt = new BankTransaction(database);
        User user1 = new User("A", "8007 345 654");
        User user2 = new User("B", "8007 325 694");
        Account account1 = new Account(10000, "4276 0600 3435 6634");
        Account account2 = new Account(10000, "4276 0600 4234 7899");
        ArrayList<Account> arrayList1 = new ArrayList<>();
        ArrayList<Account> arrayList2 = new ArrayList<>();
        arrayList1.add(account1);
        arrayList2.add(account2);
        database.put(user1, arrayList1);
        database.put(user2, arrayList2);
        bt.transferMoney(user1, account1, user2, account2, 4000);
        assertThat(database.get(user1).get(0).getValue(), is(6000.0));
        assertThat(database.get(user2).get(0).getValue(), is(14000.0));
    }
}
