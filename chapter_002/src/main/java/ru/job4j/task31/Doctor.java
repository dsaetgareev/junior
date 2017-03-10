package ru.job4j.task31;

/**
 * Class Doctor.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 10.03.2017
 * @version 1.0
 */
public class Doctor extends Professional {
    /**
     * Constructor Doctor.
     * @param name - String
     * @param age - int
     * @param specialization - specialization
     * @param salary - salary
     * @param health - health
     * @param education - education
     * @param comfort - comfort
     */
    public Doctor(String name, int age, String specialization, int salary, int health, int education, int comfort) {
        super(name, age, specialization, salary, health, education, comfort);
    }

    /**
     * method heal(Professional professional) increases health.
     * @param professional - Professional
     */
    public void heal(Professional professional) {
        int dHealth = professional.getHealth() + 10;
        professional.setHealth(dHealth);
    }
}
