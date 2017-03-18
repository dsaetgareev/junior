package ru.job4j.start;

/**
 * class TrackerMenuRuss implements TrackerMenu implements the menu in Russian.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 17.03.2017
 * @version 1.0
 */
public class TrackerMenuRuss implements TrackerMenu {
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
     * Constructor TrackerMenuRuss(Input input, Tracker tracker).
     * @param input - Input
     * @param tracker - Tracker
     */
    public TrackerMenuRuss(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * method descriptionTrackerRuss - description a menu.
     */
    public void descriptionTracker() {
        System.out.println("Здравствуйте!\n Данная программа учета заявок.\n "
                + "Выберите пункт меню, чтобы добавить новый элемент - 0,\n"
                + "показать элементы - 1, заменить элемент - 2, удалить элемент - 3,\n"
                + "найти по id - 4, найти по ключу - 5, показать удаленные элементы - 6,\n"
                + "восстановить удаленный элемент - 7, добавить новый комментарий элементу - 8.\n"
                + "----------------------------------------------------------------------------");
    }
    /**
     * method void fillAction() - fills in an array UserAction object.
     */
    public void fillAction() {
        this.actions[0] = new TrackerMenuRuss.AddItemRuss();
        this.actions[1] = new TrackerMenuRuss.ShowItemRuss();
        this.actions[2] = new TrackerMenuRuss.UpdateActionRuss();
        this.actions[3] = new TrackerMenuRuss.DeleteActionRuss();
        this.actions[4] = new TrackerMenuRuss.FindByIdActionRuss();
        this.actions[5] = new TrackerMenuRuss.FindByKeyActionRuss();
        this.actions[6] = new TrackerMenuRuss.ShowDeleteItemActionRuss();
        this.actions[7] = new TrackerMenuRuss.RestoreActionRuss();
        this.actions[8] = new TrackerMenuRuss.AddCommentActionRuss();
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
     * public class AddItemRuss implements UserAction add new item.
     */
    public class AddItemRuss implements UserAction {
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
            String name = input.ask("Пожалуйста, введите имя задачи: ");
            String desc = input.ask("Пожалуйста, введите описание задачи: ");
            String create = input.ask("Пожалуйста, введите дату создания задачи: ");
            Long createLong = Long.parseLong(create);
            String comments = input.ask("Пожалуйса, введите комментарий к задаче: ");
            tracker.add(new Item(null, name, desc, createLong, comments));
        }

        /**
         * method String info() return info.
         * @return info - String
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Добавить новую задачу.");
        }
    }

    /**
     * class ShowItemRuss implements UserAction show items.
     */
    public class ShowItemRuss implements UserAction {
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
            return String.format("%s. %s", this.key(), "Показать элементы.");
        }
    }

    /**
     * class UpdateActionRuss implements UserAction edit item.
     */
    public static class UpdateActionRuss implements UserAction {
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
            String id = input.ask("Пожалуйста, введите id заменяемого элемента: ");
            String name = input.ask("Пожалуйста, введите новое имя: ");
            String desc = input.ask("Пожалуйста, введите новое описание задачи: ");
            String create = input.ask("Пожалуйста, введите дату изменения задачи: ");
            Long createLong = Long.parseLong(create);
            String comments = input.ask("Пожалуйста, введите новый комментарий к задаче: ");
            Item item = new Item(null, name, desc, createLong, comments);
            item.setId(id);
            tracker.update(item);
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Изменить элемент.");
        }
    }

    /**
     * class DeleteActionRuss implements UserAction delete item.
     */
    public class DeleteActionRuss implements UserAction {
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
            String id = input.ask("Пожалуйста, введите id удаляемого элемента: ");
            Item item = new Item(null, " ", " ", 123, null);
            item.setId(id);
            tracker.delete(item);
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Удалить элемент.");
        }
    }
    /**
     * class ShowDeleteItemActionRuss implements UserAction show items.
     */
    public class ShowDeleteItemActionRuss implements UserAction {
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
            return String.format("%s. %s", this.key(), "Показать удаленные элементы.");
        }
    }
    /**
     * class FindByIdActionRuss implements UserAction find by id item.
     */
    public class FindByIdActionRuss implements UserAction {
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
            Item item =  tracker.findById(input.ask("Пожалуйста, введите id элемента: "));
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
            return String.format("%s. %s", this.key(), "Найти элемент по id.");
        }
    }
    /**
     * class FindByKeyActionRuss implements UserAction find by key item.
     */
    public class FindByKeyActionRuss implements UserAction {
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
            Item[] items =  tracker.findByName(input.ask("Пожалуйста, введите ключ: "));
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
            return String.format("%s. %s", this.key(), "Найти элемент по ключу.");
        }
    }
    /**
     * class RestoreActionRuss implements UserAction restore item.
     */
    public class RestoreActionRuss implements UserAction {
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
            String id = input.ask("Пожалуйста, введите id востанавливаемого элемента: ");
            tracker.restoreById(id);
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Восстановить удаленный элемент.");
        }
    }
    /**
     * class AddCommentActionRuss implements UserAction adds comment in item.
     */
    public class AddCommentActionRuss implements UserAction {
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
            String id = input.ask("Пожалуйста, введите id элемента: ");
            String comments = input.ask("Пожалуйста, введите новый комментарий: ");
            tracker.comment(comments, id);
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Добавить новый коментарий элементу по id.");
        }
    }
}
