package ru.job4j.task31;

/**
 * Class Engineer.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 10.03.2017
 * @version 1.0
 */
public class Engineer extends Professional {
    /**
     * Constructor Engineer.
     * @param name - String
     * @param age - int
     * @param specialization - String
     * @param salary - int
     * @param health - int
     * @param education - int
     * @param comfort - int
     */
    public Engineer(String name, int age, String specialization, int salary, int health, int education, int comfort) {
        super(name, age, specialization, salary, health, education, comfort);
    }

    /**
     * method constructor(Professional professional) increases comfort.
     * @param professional - Professional
     */
    public void constructor(Professional professional) {
        int eComfort = professional.getComfort() + 10;
        professional.setComfort(eComfort);
    }
}
