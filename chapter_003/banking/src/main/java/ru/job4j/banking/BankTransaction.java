package ru.job4j.banking;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

/**
 * class BankTransaction contains methods that conduct banking operations.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 02.04.2017
 * @version 1.0
 */
public class BankTransaction {
    /**
     * database.
     */
    private Map<User, List<Account>> database = new HashMap<>();

    /**
     * constructor BankTransaction(Map<User, List<Account>> database).
     * @param database - this.database
     */
    public BankTransaction(Map<User, List<Account>> database) {
        this.database = database;
    }

    /**
     * add a new user to database.
     * @param user - a new user
     */
    public void addUser(User user) {
            database.put(user, new ArrayList<Account>());
    }

    /**
     * delete a user.
     * @param user - user you wont to delete
     */
    public void deleteUser(User user) {
        if (user != null && database.containsKey(user)) {
            this.database.remove(user);
        }
    }

    /**
     * adds a account to List.
     * @param user - user to whom add
     * @param account - that add
     */
    public void addAccountToUser(User user, Account account) {
        if (user != null && database.containsKey(user)) {
            this.database.get(user).add(account);
        }
    }

    /**
     * delete a account from List.
     * @param user - user from whom delete
     * @param account - from which delete
     */
    public void deleteAccountFromUser(User user, Account account) {
        if (user != null && database.containsKey(user)) {
            Iterator<Account> iterator = this.database.get(user).iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals(account)) {
                    iterator.remove();
                    break;
                }
            }
        }
    }


    /**
     * get list user's account.
     * @param user - User
     * @return list
     */
    public List<Account> getUserAccounts(User user) {
        if (user != null && database.containsKey(user)) {
            return this.database.get(user);
        }
        return this.database.get(user);
    }

    /**
     * money transfer from one user to another.
     * @param srcUser - source user
     * @param srcAccount source Account
     * @param dstUser - destination user
     * @param dstAccount - destination account
     * @param amount - amount money
     * @return transfer
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean transfer = false;
        if (srcUser != null && database.containsKey(srcUser)
                && dstUser != null && database.containsKey(dstUser)) {
            for (Account srcTemp : this.database.get(srcUser)) {
                for (Account dstTemp : this.database.get(dstUser)) {
                    if (srcTemp.equals(srcAccount) && srcTemp.getValue() > amount
                            && dstTemp.equals(dstAccount)) {
                        srcTemp.setValue(srcTemp.getValue() - amount);
                        dstTemp.setValue(dstTemp.getValue() + amount);
                        transfer = true;
                    }
                }
            }
        }
        return transfer;
    }
}
