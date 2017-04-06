package ru.job4j.subdivision;



/**
 * class Structure describes structure subdivision and sorts the structure.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 06.04.2017
 * @version 1.0
 */
public class Structure implements Comparable<Structure> {
    /**
     * subdivision.
     */
    private String subdivision;

    /**
     * constructor.
     * @param subdivision - new subdivision
     */
    public Structure(String subdivision) {
        this.subdivision = subdivision;
    }

    /**
     * getSubdivision.
     * @return this.subdivision
     */
    public String getSubdivision() {
        return this.subdivision;
    }

    /**
     * override toString.
     * @return subdivision
     */
    @Override
    public String toString() {
        return "Structure{subdivision='" + subdivision + '\'' + '}';
    }

    /**
     * implements compareTo().
     * @param structure - another structure
     * @return value - int
     */
    public int compareTo(Structure structure) {
       return  this.getSubdivision().compareTo(structure.getSubdivision());
    }

    /**
     * override equals().
     * @param o - Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Structure structure = (Structure) o;

        return subdivision != null ? subdivision.equals(structure.subdivision) : structure.subdivision == null;
    }

    /**
     * override hashCode().
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return subdivision != null ? subdivision.hashCode() : 0;
    }

}
