package ru.job4j.start;

/**
 * class EnglishLanguage implements Language - has questions in English.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 24.03.2017
 */
public class EnglishLanguage implements Language {
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
    @Override
    public void fillAll() {
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
     * method fill a tracker questions.
     */
    @Override
    public void fillLanguageTracker() {
        this.languageTracker[0] = "Select:_";
        this.languageTracker[1] = "Continue? any symbol. Exit? '";
        this.languageTracker[2] = "':__ ";
        this.languageTracker[3] = "exit";
        this.languageTracker[4] = "Hello!\n This application accounting program.\n"
                + "Select a menu item to add a new element - 0,\n"
                + "Show the elements - 1, replace the element - 2, remove the element - 3,\n"
                + "Find by id - 4, find by key - 5, show deleted items - 6,\n"
                + "Restore the deleted item - 7, add a new comment to the element - 8.\n"
                + "----------------------------------------------------------------------------";
    }
    /**
     * String[] getLanguageTracker().
     * @return LanguageTracker
     */
    @Override
    public String[] getLanguageTracker() {
        return this.languageTracker;
    }
    /**
     * fill questions for AddAction.
     */
    @Override
    public void fillLanguageAdd() {
        this.languageAdd[0] = "Add the new task.";
        this.languageAdd[1] = "Please, enter the task's name: ";
        this.languageAdd[2] = "Please, enter the task's description: ";
        this.languageAdd[3] = "Please, enter the task's data of creation: ";
        this.languageAdd[4] = "Please, enter the task's comments: ";
    }
    /**
     * getLanguageAdd().
     * @return LanguageAdd
     */
    @Override
    public String[] getLanguageAdd() {
        return this.languageAdd;
    }
    /**
     * method fill questions for ShowAction.
     */
    @Override
    public void fillLanguageShow() {
        this.languageShow[0] = "Show items.";
    }
    /**
     * getLanguageShow().
     * @return LanguageShow
     */
    @Override
    public String[] getLanguageShow() {
        return this.languageShow;
    }
    /**
     * method fill questions for UpdateAction.
     */
    @Override
    public void fillLanguageUpdate() {
        this.languageUpdate[0] = "Edit item.";
        this.languageUpdate[1] = "Please, enter ID edited item: ";
        this.languageUpdate[2] = "Please, enter new task's name: ";
        this.languageUpdate[3] = "Please, enter new task's description: ";
        this.languageUpdate[4] = "Please, enter new task's data of creation: ";
        this.languageUpdate[5] = "Please, enter new task's comments: ";
    }
    /**
     * getLanguageUpdate().
     * @return LanguageUpdate
     */
    @Override
    public String[] getLanguageUpdate() {
        return this.languageUpdate;
    }
    /**
     * fill questions for DeleteAction.
     */
    @Override
    public void fillLanguageDelete() {
        this.languageDelete[0] = "Delete item.";
        this.languageDelete[1] = "Please, enter ID deleted item's: ";
    }
    /**
     * getLanguageDelete().
     * @return LanguageDelete
     */
    @Override
    public String[] getLanguageDelete() {
        return this.languageDelete;
    }
    /**
     * fill questions for ShowDeleteAction.
     */
    @Override
    public void fillLanguageShowDelete() {
        this.languageShowDelete[0] = "Show deleted items.";
    }
    /**
     * getLanguageShowDelete().
     * @return LanguageShowDelete
     */
    @Override
    public String[] getLanguageShowDelete() {
        return this.languageShowDelete;
    }
    /**
     * fill questions for FindByIdAction.
     */
    @Override
    public void fillLanguageFindById() {
        this.languageFindById[0] = "Find item by id.";
        this.languageFindById[1] = "Please, enter ID item's find by id: ";
    }
    /**
     * getLanguageFindById().
     * @return LanguageFindById
     */
    @Override
    public String[] getLanguageFindById() {
        return this.languageFindById;
    }
    /**
     * fill questions for FindByKeyAction.
     */
    @Override
    public void fillLanguageFindByKey() {
        this.languageFindByKey[0] = "Find item by key.";
        this.languageFindByKey[1] = "Please, enter ID item's find by key: ";
    }
    /**
     * getLanguageFindByKey().
     * @return LanguageFindByKey
     */
    @Override
    public String[] getLanguageFindByKey() {
        return this.languageFindByKey;
    }
    /**
     * fill questions RestoreAction.
     */
    @Override
    public void fillLanguageRestore() {
        this.languageRestore[0] = "Restore item.";
        this.languageRestore[1] = "Please, enter ID restore item's: ";
    }
    /**
     * getLanguageRestore().
     * @return LanguageRestore
     */
    @Override
    public String[] getLanguageRestore() {
        return this.languageRestore;
    }
    /**
     * fill questions AddCommentAction.
     */
    @Override
    public void fillLanguageAddComment() {
        this.languageAddComment[0] = "Add new comment.";
        this.languageAddComment[1] = "Please, enter ID item's: ";
        this.languageAddComment[2] = "Please, enter new comment: ";
    }
    /**
     * getLanguageAddComment().
     * @return LanguageAddComment
     */
    @Override
    public String[] getLanguageAddComment() {
        return this.languageAddComment;
    }
}
