package ru.job4j.calculate;

import java.util.Scanner;

/**
 * Created by dinis on 13.07.17.
 */
public class Init {


    private Input input;

    public Init() {
        this.input = new Input();
    }
    public void init() {
        double a = this.input.ask("Введите первое число!");
        double b = this.input.ask("Ввдите второе число!");
        Calculator calc = new Calculator(a, b);
        int vibor = this.input.answer("Введите 1 если сложить или 2 если вычесть");

        if (vibor == 1) {
            calc.add();
        }
        if (vibor == 2) {
            calc.delenie();
        }
    }
}
