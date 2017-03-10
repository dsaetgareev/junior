package ru.job4j.task31;

/**
 * class Teacher extends Professional.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 10.03.2017
 * @version 1.0
 */
public class Teacher extends Professional {
    /**
     *Constructor Teacher.
     * @param name - name
     * @param age - age
     * @param specialization - specilization
     * @param salary - salary
     * @param health - health
     * @param education - education
     * @param comfort - comfort
     */
    public Teacher(String name, int age, String specialization, int salary, int health, int education, int comfort) {
        super(name, age, specialization, salary, health, education, comfort);
    }

    /**
     * method learn(Professional professional) increases education.
     * @param professional - Professional
     */
    public void learn(Professional professional) {
       int tEducation = professional.getEducation() + 10;
       professional.setEducation(tEducation);
    }
}