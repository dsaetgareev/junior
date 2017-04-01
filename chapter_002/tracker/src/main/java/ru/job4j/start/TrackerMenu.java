package ru.job4j.start;

//import jdk.nashorn.internal.objects.annotations.Constructor;

import java.util.ArrayList;
import java.util.List;

/**
 * class TrackerMenu.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 15.03.2017
 * @version 1.0
 */
public class TrackerMenu {
    /**
     *Input input.
     */
    private Input input;
    /**
     * variable tracker.
     */
    private Tracker tracker;
    /**
     * Language lang.
     */
    private Language lang;
    /**
     * array List<UserAction> contains UserAction objects.
     */
    private List<UserAction> actions = new ArrayList<>();
    /**
     * Constructor TrackerMenu(Input input, Tracker tracker, Language lang).
     * @param input - Input
     * @param tracker - Tracker
     * @param lang - Language
     */
    public TrackerMenu(Input input, Tracker tracker, Language lang) {
        this.input = input;
        this.tracker = tracker;
        this.lang = lang;
    }
     /**
     * String questionSelect().
     * @return questionSelect - String
     */
    public String questionSelect() {
        return lang.getLanguageTracker()[0];
    }
    /**
     * String questionBoolean().
     * @return questionBoolean - String
     */
    public String questionBoolean() {
        return lang.getLanguageTracker()[1] + this.questionKey() + lang.getLanguageTracker()[2];
    }
    /**
     * String questionKey().
     * @return questionKey - String
     */
    public String questionKey() {
        return lang.getLanguageTracker()[3];
    }

     /**
     * method descriptionTracker - description a menu.
     */
    public void descriptionTracker() {
        System.out.println(lang.getLanguageTracker()[4]);
    }
    /**
     * method void fillAction() - fills in an array UserAction object.
     */
    public void fillAction() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowItem());
        this.actions.add(new UpdateAction());
        this.actions.add(new DeleteAction());
        this.actions.add(new FindByIdAction());
        this.actions.add(new FindByKeyAction());
        this.actions.add(new ShowDeleteItemAction());
        this.actions.add(new RestoreAction());
        this.actions.add(new AddCommentAction());
    }
    /**
     * int[] initRange() - fill Range.
     * @return range - int[]
     */
    public int[] initRange() {
        int[] range = new int[this.actions.size()];
        for (int i = 0; i < this.actions.size(); i++) {
            range[i] = i;
        }
        return range;
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
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * public class AddItem implements UserAction add new item.
     */
    public class AddItem extends BaseAction implements UserAction {

        /**
         * method key() return key for menu.
         * @return key - int
         */
        @Override
        public int key() {
            return 0;
        }

        /**
         * Constructor AddItem().
         */
        public AddItem() {
            super(String.format(lang.getLanguageAdd()[0]));
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, add new item.
         * @param input - Input
         * @param tracker - Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask(lang.getLanguageAdd()[1]);
            String desc = input.ask(lang.getLanguageAdd()[2]);
            String create = input.ask(lang.getLanguageAdd()[3]);
            Long createLong = Long.parseLong(create);
            String comments = input.ask(lang.getLanguageAdd()[4]);
            tracker.add(new Item(null, name, desc, createLong, comments));
        }

        /**
         * method String info() return info.
         * @return info - String
         */
        @Override
        public String info() {
            return String.format("[%s] %s ", this.key(), super.info());
        }
    }

    /**
     * class ShowItem implements UserAction show items.
     */
    public class ShowItem extends BaseAction implements UserAction {
        /**
         * Constructor ShowItem().
         */
        public ShowItem() {
            super(String.format(lang.getLanguageShow()[0]));
        }
        /**
         * method key() return key for menu.
         * @return key - int
         */
        @Override
        public int key() {
            return 1;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, show items.
         * @param input - Input
         * @param tracker - Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            List<Item> items = tracker.findAll();
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
         */@Override
        public String info() {
            return String.format("[%s] %s ", this.key(), super.info());
        }
    }

    /**
     * class UpdateAction implements UserAction edit item.
     */
    public class UpdateAction extends BaseAction implements UserAction {
        /**
         * Constructor UpdateAction().
         */
        public UpdateAction() {
            super(String.format(lang.getLanguageUpdate()[0]));
        }
        /**
         * method key() return key for menu.
         * @return key - int
         */
        @Override
        public int key() {
            return 2;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, show items.
         * @param input - Input
         * @param tracker - Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask(lang.getLanguageUpdate()[1]);
            String name = input.ask(lang.getLanguageUpdate()[2]);
            String desc = input.ask(lang.getLanguageUpdate()[3]);
            String create = input.ask(lang.getLanguageUpdate()[4]);
            Long createLong = Long.parseLong(create);
            String comments = input.ask(lang.getLanguageUpdate()[5]);
            Item item = new Item(null, name, desc, createLong, comments);
            item.setId(id);
            tracker.update(item);
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        @Override
        public String info() {
            return String.format("[%s] %s ", this.key(), super.info());
        }
    }

    /**
     * class DeleteAction implements UserAction delete item.
     */
    public class DeleteAction extends BaseAction implements UserAction {
        /**
         * Constructor DeleteAction().
         */
        public DeleteAction() {
            super(String.format(lang.getLanguageDelete()[0]));
        }
        /**
         * method key() return key for menu.
         * @return key - int
         */
        @Override
        public int key() {
            return 3;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, delete item.
         * @param input - Input
         * @param tracker - Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask(lang.getLanguageDelete()[1]);
            Item item = new Item(null, " ", " ", 123, null);
            item.setId(id);
            tracker.delete(item);
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        @Override
        public String info() {
            return String.format("[%s] %s ", this.key(), super.info());
        }
    }
    /**
     * class ShowItem implements UserAction show items.
     */
    public class ShowDeleteItemAction extends BaseAction implements UserAction {
        /**
         * Constructor ShowDeleteItemAction().
         */
        public ShowDeleteItemAction() {
            super(String.format(lang.getLanguageShowDelete()[0]));
        }
        /**
         * method key() return key for menu.
         * @return key - int
         */
        @Override
        public int key() {
            return 6;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, show items.
         * @param input - Input
         * @param tracker - Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            List<Item> items = tracker.findAllDeleteItems();
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
        @Override
        public String info() {
            return String.format("[%s] %s ", this.key(), super.info());
        }
    }
    /**
     * class FindByIdAction implements UserAction find by id item.
     */
    public class FindByIdAction extends BaseAction implements UserAction {
        /**
         * Constructor FindByIdAction().
         */
        public FindByIdAction() {
            super(String.format(lang.getLanguageFindById()[0]));
        }
        /**
         * method key() return key for menu.
         * @return key - int
         */
        @Override
        public int key() {
            return 4;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, find item by id.
         * @param input - Input
         * @param tracker - Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
           Item item =  tracker.findById(input.ask(lang.getLanguageFindById()[1]));
                System.out.println(String.format(
                        "[%s] [%s] [%s] [%s] [%s]",
                        item.getId(), item.getName(), item.getDesc(), item.getCreate(), item.getComments())
                );
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        @Override
        public String info() {
            return String.format("[%s] %s ", this.key(), super.info());
        }
    }
    /**
     * class FindByKeyAction implements UserAction find by key item.
     */
    public class FindByKeyAction extends BaseAction implements UserAction {
        /**
         * Constructor FindByKeyAction().
         */
        public FindByKeyAction() {
            super(String.format(lang.getLanguageFindByKey()[0]));
        }
        /**
         * method key() return key for menu.
         * @return key - int
         */
        @Override
        public int key() {
            return 5;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, find item by key.
         * @param input - Input
         * @param tracker - Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            List<Item> items =  tracker.findByName(input.ask(lang.getLanguageFindByKey()[1]));
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
        @Override
        public String info() {
            return String.format("[%s] %s ", this.key(), super.info());
        }
    }
    /**
     * class RestoreAction implements UserAction restore item.
     */
    public class RestoreAction extends BaseAction implements UserAction {
        /**
         * Constructor RestoreAction().
         */
        public RestoreAction() {
            super(String.format(lang.getLanguageRestore()[0]));
        }
        /**
         * method key() return key for menu.
         * @return key - int
         */
        @Override
        public int key() {
            return 7;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, restore item.
         * @param input - Input
         * @param tracker - Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask(lang.getLanguageRestore()[1]);
            tracker.restoreById(id);
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        @Override
        public String info() {
            return String.format("[%s] %s ", this.key(), super.info());
        }
    }
    /**
     * class AddCommentAction implements UserAction adds comment in item.
     */
    public class AddCommentAction extends BaseAction implements UserAction {
        /**
         * Constructor AddCommentAction().
         */
        public AddCommentAction() {
            super(String.format(lang.getLanguageAddComment()[0]));
        }
        /**
         * method key() return key for menu.
         * @return key - int
         */
        @Override
        public int key() {
            return 8;
        }
        /**
         * method void execute(Input input, Tracker tracker) executes class, adds comment in item.
         * @param input - Input
         * @param tracker - Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask(lang.getLanguageAddComment()[1]);
            String comments = input.ask(lang.getLanguageAddComment()[2]);
            tracker.comment(comments, id);
        }
        /**
         * method String info() return info.
         * @return info - String
         */
        @Override
        public String info() {
            return String.format("[%s] %s ", this.key(), super.info());
        }
    }
}
