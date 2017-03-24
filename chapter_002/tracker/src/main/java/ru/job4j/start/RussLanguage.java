package ru.job4j.start;

/**
 * class RussLanguage implements Language - has questions in Russian.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 24.03.2017
 * @version 1.0
 */
public class RussLanguage implements Language {
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
        this.languageTracker[0] = "Выбор:_";
        this.languageTracker[1] = "Продолжить? любой символ. Exit? '";
        this.languageTracker[2] = "':__ ";
        this.languageTracker[3] = "выход";
        this.languageTracker[4] = "Здравствуйте!\n Данная программа учета заявок.\n "
                + "Выберите пункт меню, чтобы добавить новый элемент - 0,\n"
                + "показать элементы - 1, заменить элемент - 2, удалить элемент - 3,\n"
                + "найти по id - 4, найти по ключу - 5, показать удаленные элементы - 6,\n"
                + "восстановить удаленный элемент - 7, добавить новый комментарий элементу - 8.\n"
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
        this.languageAdd[0] = "Добавить новую задачу.";
        this.languageAdd[1] = "Пожалуйста, введите имя задачи: ";
        this.languageAdd[2] = "Пожалуйста, введите описание задачи: ";
        this.languageAdd[3] = "Пожалуйста, введите дату создания задачи: ";
        this.languageAdd[4] = "Пожалуйса, введите комментарий к задаче: ";
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
        this.languageShow[0] = "Показать элементы.";
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
        this.languageUpdate[0] = "Изменить элемент.";
        this.languageUpdate[1] = "Пожалуйста, введите id заменяемого элемента: ";
        this.languageUpdate[2] = "Пожалуйста, введите новое имя: ";
        this.languageUpdate[3] = "Пожалуйста, введите новое описание задачи: ";
        this.languageUpdate[4] = "Пожалуйста, введите дату изменения задачи: ";
        this.languageUpdate[5] = "Пожалуйста, введите новый комментарий к задаче: ";
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
        this.languageDelete[0] = "Удалить элемент.";
        this.languageDelete[1] = "Пожалуйста, введите id удаляемого элемента: ";
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
        this.languageShowDelete[0] = "Показать удаленные элементы.";
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
        this.languageFindById[0] = "Найти элемент по id.";
        this.languageFindById[1] = "Пожалуйста, введите id элемента: ";
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
        this.languageFindByKey[0] = "Найти элемент по ключу.";
        this.languageFindByKey[1] = "Пожалуйста, введите ключ: ";
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
        this.languageRestore[0] = "Восстановить удаленный элемент.";
        this.languageRestore[1] = "Пожалуйста, введите id востанавливаемого элемента: ";
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
        this.languageAddComment[0] = "Добавить новый коментарий элементу по id.";
        this.languageAddComment[1] = "Пожалуйста, введите id элемента: ";
        this.languageAddComment[2] = "Пожалуйста, введите новый комментарий: ";
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
