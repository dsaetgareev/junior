package ru.job4j.start;

/**
 * class TrackerMenu.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 15.03.2017
 * @version 1.0
 */
public class TrackerMenuEnglish implements TrackerMenu {
    /**
     *Input input.
     */
    private Input input;
    /**
     * variable tracker.
     */
    private Tracker tracker;
    /**
     * array UserAction[] contains UserAction objects.
     */
    private UserAction[] actions = new UserAction[9];

    /**
     * Constructor TrackerMenu(Input input, Tracker tracker).
     * @param input - Input
     * @param tracker - Tracker
     */
    public TrackerMenuEnglish(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * method descriptionTracker - description a menu.
     */
    public void descriptionTracker() {
        System.out.println("Hello!\n This application accounting program.\n"
                + "Select a menu item to add a new element - 0,\n"
                + "Show the elements - 1, replace the element - 2, remove the element - 3,\n"
                + "Find by id - 4, find by key - 5, show deleted items - 6,\n"
                + "Restore the deleted item - 7, add a new comment to the element - 8.\n"
                + "----------------------------------------------------------------------------");
    }
    /**
     * method void fillAction() - fills in an array UserAction object.
     */
    public void fillAction() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItem();
        this.actions[2] = new UpdateAction();
        this.actions[3] = new DeleteAction();
        this.actions[4] = new FindByIdAction();
        this.actions[5] = new FindByKeyAction();
        this.actions[6] = new ShowDeleteItemAction();
        this.actions[7] = new RestoreAction();
        this.actions[8] = new AddCommentAction();
    }

    /**
     * method void show() - show a menu.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * method void select(int key) - executes class by key.
     * @param key - int
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * public class AddItem implements UserAction add new item.
     */
    public class AddItem implements UserAction {
        /**
         * method key() return key for menu.
         * @return key - int
         */
        public int key() {
            return 0;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, add new item.
         * @param input - Input
         * @param tracker - Tracker
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            String desc = input.ask("Please, enter the task's description: ");
            String create = input.ask("Please, enter the task's data of creation: ");
            Long createLong = Long.parseLong(create);
            String comments = input.ask("Please, enter the task's comments: ");
            tracker.add(new Item(null, name, desc, createLong, comments));
        }

        /**
         * method String info() return info.
         * @return info - String
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new task.");
        }
    }

    /**
     * class ShowItem implements UserAction show items.
     */
    public class ShowItem implements UserAction {
        /**
         * method key() return key for menu.
         * @return key - int
         */
        public int key() {
            return 1;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, show items.
         * @param input - Input
         * @param tracker - Tracker
         */
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findAll();
            for (Item item : items) {
                if (item != null) {
                    System.out.println(String.format(
                            "[%s] [%s] [%s] [%s] [%s]",
                            item.getId(), item.getName(), item.getDesc(), item.getCreate(), item.getComments())
                    );
                }
            }
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show items.");
        }
    }

    /**
     * class UpdateAction implements UserAction edit item.
     */
    public static class UpdateAction implements UserAction {
        /**
         * method key() return key for menu.
         * @return key - int
         */
        public int key() {
            return 2;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, show items.
         * @param input - Input
         * @param tracker - Tracker
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter ID edited item: ");
            String name = input.ask("Please, enter new task's name: ");
            String desc = input.ask("Please, enter new task's description: ");
            String create = input.ask("Please, enter new task's data of creation: ");
            Long createLong = Long.parseLong(create);
            String comments = input.ask("Please, enter new task's comments: ");
            Item item = new Item(null, name, desc, createLong, comments);
            item.setId(id);
            tracker.update(item);
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item.");
        }
    }

    /**
     * class DeleteAction implements UserAction delete item.
     */
    public class DeleteAction implements UserAction {
        /**
         * method key() return key for menu.
         * @return key - int
         */
        public int key() {
            return 3;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, delete item.
         * @param input - Input
         * @param tracker - Tracker
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter ID deleted item's: ");
            Item item = new Item(null, " ", " ", 123, null);
            item.setId(id);
            tracker.delete(item);
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }
    }
    /**
     * class ShowItem implements UserAction show items.
     */
    public class ShowDeleteItemAction implements UserAction {
        /**
         * method key() return key for menu.
         * @return key - int
         */
        public int key() {
            return 6;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, show items.
         * @param input - Input
         * @param tracker - Tracker
         */
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findAllDeleteItems();
            for (Item item : items) {
                if (item != null) {
                    System.out.println(String.format(
                            "[%s] [%s] [%s] [%s] [%s]",
                            item.getId(), item.getName(), item.getDesc(), item.getCreate(), item.getComments())
                    );
                }
            }
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show deleted items.");
        }
    }
    /**
     * class FindByIdAction implements UserAction find by id item.
     */
    public class FindByIdAction implements UserAction {
        /**
         * method key() return key for menu.
         * @return key - int
         */
        public int key() {
            return 4;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, find item by id.
         * @param input - Input
         * @param tracker - Tracker
         */
        public void execute(Input input, Tracker tracker) {
           Item item =  tracker.findById(input.ask("Please, enter ID item's find by id: "));
                System.out.println(String.format(
                        "[%s] [%s] [%s] [%s] [%s]",
                        item.getId(), item.getName(), item.getDesc(), item.getCreate(), item.getComments())
                );
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by id.");
        }
    }
    /**
     * class FindByKeyAction implements UserAction find by key item.
     */
    public class FindByKeyAction implements UserAction {
        /**
         * method key() return key for menu.
         * @return key - int
         */
        public int key() {
            return 5;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, find item by key.
         * @param input - Input
         * @param tracker - Tracker
         */
        public void execute(Input input, Tracker tracker) {
            Item[] items =  tracker.findByName(input.ask("Please, enter a key: "));
            for (Item item : items) {
                System.out.println(String.format(
                        "[%s] [%s] [%s] [%s] [%s]",
                        item.getId(), item.getName(), item.getDesc(), item.getCreate(), item.getComments())
                );
            }
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by key.");
        }
    }
    /**
     * class RestoreAction implements UserAction restore item.
     */
    public class RestoreAction implements UserAction {
        /**
         * method key() return key for menu.
         * @return key - int
         */
        public int key() {
            return 7;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, restore item.
         * @param input - Input
         * @param tracker - Tracker
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter ID restore item's: ");
            tracker.restoreById(id);
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Restore item.");
        }
    }
    /**
     * class AddCommentAction implements UserAction adds comment in item.
     */
    public class AddCommentAction implements UserAction {
        /**
         * method key() return key for menu.
         * @return key - int
         */
        public int key() {
            return 8;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, adds comment in item.
         * @param input - Input
         * @param tracker - Tracker
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter ID item's: ");
            String comments = input.ask("Please, enter new comment: ");
            tracker.comment(comments, id);
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add new comment.");
        }
    }
}
