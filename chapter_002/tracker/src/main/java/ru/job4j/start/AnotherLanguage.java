package ru.job4j.start;

/**
 * Created by dinis on 24.03.2017.
 */
public class AnotherLanguage implements Language {
    /**
     * Input input.
     */
    private Input input = new ConsoleInput();
    /**
     * array questions languageTracker.
     */
    private String[] languageTracker = new String[5];
    /**
     * array questions languageAdd.
     */
    private String[] languageAdd = new String[5];
    /**
     * array questions languageShow.
     */
    private String[] languageShow = new String[1];
    /**
     * array questions languageUpdate.
     */
    private String[] languageUpdate = new String[6];
    /**
     * array questions languageDelete.
     */
    private String[] languageDelete = new String[2];
    /**
     * array questions languageShowDelete.
     */
    private String[] languageShowDelete = new String[1];
    /**
     * array questions languageFindById.
     */
    private String[] languageFindById = new String[2];
    /**
     * array questions languageFindByKey.
     */
    private String[] languageFindByKey = new String[2];
    /**
     * array questions languageRestore.
     */
    private String[] languageRestore = new String[2];
    /**
     * array questions languageAddComment.
     */
    private String[] languageAddComment = new String[3];
    /**
     * fillAll - fill all methods.
     */
    public void fillAll() {
        this.instruction();
        this.fillLanguageTracker();
        this.fillLanguageAdd();
        this.fillLanguageShow();
        this.fillLanguageUpdate();
        this.fillLanguageDelete();
        this.fillLanguageShowDelete();
        this.fillLanguageFindById();
        this.fillLanguageFindByKey();
        this.fillLanguageRestore();
        this.fillLanguageAddComment();
    }

    /**
     * instruction how add language.
     */
    public void instruction() {
        System.out.println("Using an interpreter translate\n phrases into your language.\n"
                + " Only your language will be used later.");
    }
    /**
     * method fill a tracker questions.
     */
    public void fillLanguageTracker() {
        this.languageTracker[0] = this.input.ask("Select:_");
        this.languageTracker[1] = this.input.ask("Continue? any symbol. Exit? enter 'exit'___");
        this.languageTracker[2] = this.input.ask("':__ ");
        this.languageTracker[3] = this.input.ask("exit__");
        this.languageTracker[4] = this.input.ask("Hello!\n This application accounting program.\n"
                + "Select a menu item to add a new element - 0,\n"
                + "Show the elements - 1, replace the element - 2, remove the element - 3,\n"
                + "Find by id - 4, find by key - 5, show deleted items - 6,\n"
                + "Restore the deleted item - 7, add a new comment to the element - 8.\n"
                + "----------------------------------------------------------------------------");
    }
    /**
     * String[] getLanguageTracker().
     * @return LanguageTracker
     */
    public String[] getLanguageTracker() {
        return this.languageTracker;
    }
    /**
     * fill questions for AddAction.
     */
    public void fillLanguageAdd() {
        this.languageAdd[0] = input.ask("Add the new task.___");
        this.languageAdd[1] = input.ask("Please, enter the task's name: ___");
        this.languageAdd[2] = input.ask("Please, enter the task's description:___ ");
        this.languageAdd[3] = input.ask("Please, enter the task's data of creation: ___");
        this.languageAdd[4] = input.ask("Please, enter the task's comments: ___");
    }
    /**
     * getLanguageAdd().
     * @return LanguageAdd
     */
    public String[] getLanguageAdd() {
        return this.languageAdd;
    }
    /**
     * method fill questions for ShowAction.
     */
    public void fillLanguageShow() {
        this.languageShow[0] = input.ask("Show items.___");
    }
    /**
     * getLanguageShow().
     * @return LanguageShow
     */
    public String[] getLanguageShow() {
        return this.languageShow;
    }
    /**
     * method fill questions for UpdateAction.
     */
    public void fillLanguageUpdate() {
        this.languageUpdate[0] = input.ask("Edit item.___");
        this.languageUpdate[1] = input.ask("Please, enter ID edited item: ___");
        this.languageUpdate[2] = input.ask("Please, enter new task's name: ___");
        this.languageUpdate[3] = input.ask("Please, enter new task's description: ___");
        this.languageUpdate[4] = input.ask("Please, enter new task's data of creation: ___");
        this.languageUpdate[5] = input.ask("Please, enter new task's comments: ___");
    }
    /**
     * getLanguageUpdate().
     * @return LanguageUpdate
     */
    public String[] getLanguageUpdate() {
        return this.languageUpdate;
    }
    /**
     * fill questions for DeleteAction.
     */
    public void fillLanguageDelete() {
        this.languageDelete[0] = input.ask("Delete item.___");
        this.languageDelete[1] = input.ask("Please, enter ID deleted item's: ___");
    }
    /**
     * getLanguageDelete().
     * @return LanguageDelete
     */
    public String[] getLanguageDelete() {
        return this.languageDelete;
    }
    /**
     * fill questions for ShowDeleteAction.
     */
    public void fillLanguageShowDelete() {
        this.languageShowDelete[0] = input.ask("Show deleted items.___");
    }
    /**
     * getLanguageShowDelete().
     * @return LanguageShowDelete
     */
    public String[] getLanguageShowDelete() {
        return this.languageShowDelete;
    }
    /**
     * fill questions for FindByIdAction.
     */
    public void fillLanguageFindById() {
        this.languageFindById[0] = input.ask("Find item by id.___");
        this.languageFindById[1] = input.ask("Please, enter ID item's find by id: ___");
    }
    /**
     * getLanguageFindById().
     * @return LanguageFindById
     */
    public String[] getLanguageFindById() {
        return this.languageFindById;
    }
    /**
     * fill questions for FindByKeyAction.
     */
    public void fillLanguageFindByKey() {
        this.languageFindByKey[0] = input.ask("Find item by key.___");
        this.languageFindByKey[1] = input.ask("Please, enter ID item's find by key: ___");
    }
    /**
     * getLanguageFindByKey().
     * @return LanguageFindByKey
     */
    public String[] getLanguageFindByKey() {
        return this.languageFindByKey;
    }
    /**
     * fill questions RestoreAction.
     */
    public void fillLanguageRestore() {
        this.languageRestore[0] = input.ask("Restore item.___");
        this.languageRestore[1] = input.ask("Please, enter ID restore item's: ___");
    }
    /**
     * getLanguageRestore().
     * @return LanguageRestore
     */
    public String[] getLanguageRestore() {
        return this.languageRestore;
    }
    /**
     * fill questions AddCommentAction.
     */
    public void fillLanguageAddComment() {
        this.languageAddComment[0] = input.ask("Add new comment.___");
        this.languageAddComment[1] = input.ask("Please, enter ID item's: ___");
        this.languageAddComment[2] = input.ask("Please, enter new comment: ___");
    }
    /**
     * getLanguageAddComment().
     * @return LanguageAddComment
     */
    public String[] getLanguageAddComment() {
        return this.languageAddComment;
    }
}

