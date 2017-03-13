package ru.job4j.task31;

/**
 * Class Professional.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 10.03.2017
 * @version 1.0
 */
public class Professional {
    /**
     * String name - professional name.
     */
    private String name;
    /**
     * int age - professional age.
     */
    private int age;
    /**
     * String specialization.
     */
    private String specialization;
    /**
     * int salary.
     */
    private int salary;
    /**
     * int healt.
     */
    private int health;
    /**
     * int education.
     */
    private int education;
    /**
     * int comfort.
     */
    private int comfort;

    /**
     * Constructor Professional.
     * @param name - name
     * @param age - age
     * @param specialization - spec
     * @param salary - salary
     * @param health - health
     * @param education - ed
     * @param comfort - comf
     */
    public Professional(String name, int age, String specialization, int salary, int health, int education, int comfort) {
        this.name = name;
        this.age = age;
        this.specialization = specialization;
        this.salary = salary;
        this.health = health;
        this.education = education;
        this.comfort = comfort;
    }

    /**
     * method additional(int value) adds to the salary of value.
     * @param value - value
     */
    public void additional(int value) {
        this.salary += value;
    }

    /**
     * getSalary().
     * @return salary - int
     */
    public int getSalary() {
        return salary;
    }
    /**
     * getter getHealth().
     * @return health - int
     */
    public int getHealth() {
        return health;
    }

    /**
     * setHealth(int value) setting health.
     * @param value - int
     */
    public void setHealth(int value) {
        health = value;
    }
    /**
     * int getEducation.
     * @return education - int
     */
    public int getEducation() {
        return education;
    }

    /**
     * setEducation(int value) setting education.
     * @param value - int
     */
    public void setEducation(int value) {
        education = value;
    }

    /**
     * int getComfort().
     * @return comfort - int
     */
    public int getComfort() {
        return comfort;
    }

    /**
     * setComfort(int value) setting comfort.
     * @param value - int
     */
    public void setComfort(int value) {
        comfort = value;
    }
}