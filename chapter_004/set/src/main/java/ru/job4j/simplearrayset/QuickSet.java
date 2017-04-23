package ru.job4j.simplearrayset;

/**
 * class QuickSet<E> extends SimpleArraySet<E> implements quick set.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 20.04.2017
 * @version 1.0
 * @param <E> - some type
 */
public class QuickSet<E> extends SimpleArraySet<E> {
    /**
     * constructor.
     */
    public QuickSet() {
        super();
    }

    /**
     * adds new element.
     * @param e - new element
     */
    @Override
    public void add(E e) {
        if (super.size() == 0 || e.hashCode() > super.getArraySet()[super.size() - 1].hashCode()
                || e.hashCode() < super.getArraySet()[0].hashCode()) {
            if (super.size() == 0
                    || e.hashCode() > super.getArraySet()[super.size() - 1].hashCode()) {
                super.getArraySet()[super.size()] = e;
                super.sizeIter();
                super.increaseArray();
            }
            if (e.hashCode() < super.getArraySet()[0].hashCode()) {
                shiftCells(-1);
                super.getArraySet()[0] = e;
                super.sizeIter();
                super.increaseArray();
            }
        } else {
            int index = indexSearch(e);
            if (hasDuplicate(e, index)) {
                add(index, e);
                super.increaseArray();
            }
        }
    }

    /**
     * adds new element by index.
     * @param index index
     * @param e - new element
     */
    public void add(int index, E e) {
        shiftCells(index);
        super.getArraySet()[index + 1] = e;
        super.sizeIter();
    }

    /**
     * shifts cells of array.
     * @param index - index
     */
    public void shiftCells(int index) {
        System.arraycopy(super.getArraySet(), index + 1, super.getArraySet(),
                index + 2, super.size() - index - 1);
    }

    /**
     * checks for availability duplicates.
     * @param e new element
     * @param index index
     * @return boolean
     */
    public boolean hasDuplicate(E e, int index) {
        int hash = e.hashCode();
        boolean result = true;
        for (int i = index; index >= 0; i--) {
            if (hash != super.getArraySet()[i].hashCode()) {
                break;
            } else {
                if (e.equals(super.getArraySet()[i])) {
                    result = false;
                    break;
                }
            }
        }
        for (int i = index; index < super.size() - 1; i++) {
            if (hash != super.getArraySet()[i].hashCode()) {
                break;
            } else {
                if (e.equals(super.getArraySet()[i])) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Finds the index in which you want to insert.
     * @param e new element
     * @return index
     */
    public int indexSearch(E e) {
        int result = 0;
        int hash = e.hashCode();
        int index = 0;
        int first = 0;
        int last = super.size();

        do {
            index = (last - first) / 2 + first;

            if (hash >= super.getArraySet()[index].hashCode()
                    && hash < super.getArraySet()[index + 1].hashCode()) {
                result =  index;
                break;
            }
            if (hash < super.getArraySet()[index].hashCode()) {
                last = index;
            }
            if (hash > super.getArraySet()[index].hashCode()) {
                first = index;
            }
        } while (true);
        return result;
    }
}
