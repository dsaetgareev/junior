package ru.job4j.calculate;

/**
 * Created by dinis on 13.07.17.
 */
public class Calculator {

    private double a;
    private double b;

    public Calculator(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double add() {
        double sum = this.a + this.b;
        System.out.println("Результат: " + sum);
        return sum;
    }

    public double delenie() {
        double result = 0;
        if (b != 0) {
            result = a / b;
            System.out.println(result);
        } else {
            System.out.println("На ноль делить нельзя!!");
        }
        return result;
    }
}
