package ru.job4j.start;

/**
 * Interface Language.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 24.03.2017
 * @version 1.0
 */
public interface Language {
    /**
     * fillAll - fill all methods.
     */
    void fillAll();

    /**
     * method fill a tracker questions.
     */
    void fillLanguageTracker();

    /**
     * String[] getLanguageTracker().
     * @return LanguageTracker
     */
    String[] getLanguageTracker();

    /**
     * fill questions for AddAction.
     */
    void fillLanguageAdd();

    /**
     * getLanguageAdd().
     * @return LanguageAdd
     */
    String[] getLanguageAdd();

    /**
     * method fill questions for ShowAction.
     */
    void fillLanguageShow();

    /**
     * getLanguageShow().
     * @return LanguageShow
     */
    String[] getLanguageShow();

    /**
     * method fill questions for UpdateAction.
     */
    void fillLanguageUpdate();

    /**
     * getLanguageUpdate().
     * @return LanguageUpdate
     */
    String[] getLanguageUpdate();

    /**
     * fill questions for DeleteAction.
     */
    void fillLanguageDelete();

    /**
     * getLanguageDelete().
     * @return LanguageDelete
     */
    String[] getLanguageDelete();

    /**
     * fill questions for ShowDeleteAction.
     */
    void fillLanguageShowDelete();

    /**
     * getLanguageShowDelete().
     * @return LanguageShowDelete
     */
    String[] getLanguageShowDelete();

    /**
     * fill questions for FindByIdAction.
     */
    void fillLanguageFindById();

    /**
     * getLanguageFindById().
     * @return LanguageFindById
     */
    String[] getLanguageFindById();

    /**
     * fill questions for FindByKeyAction.
     */
    void fillLanguageFindByKey();

    /**
     * getLanguageFindByKey().
     * @return LanguageFindByKey
     */
    String[] getLanguageFindByKey();

    /**
     * fill questions RestoreAction.
     */
    void fillLanguageRestore();

    /**
     * getLanguageRestore().
     * @return LanguageRestore
     */
    String[] getLanguageRestore();

    /**
     * fill questions AddCommentAction.
     */
    void fillLanguageAddComment();

    /**
     * getLanguageAddComment().
     * @return LanguageAddComment
     */
    String[] getLanguageAddComment();
}
