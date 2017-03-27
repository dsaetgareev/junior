package ru.job4j.bank;

import java.util.Arrays;

/**
 * class Bank implements work of a bank.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 24.03.2017
 */
public class Bank {
    /**
     * array working time of the bank.
     */
    private WorkingTime[] workingTimes = new WorkingTime[12];
    //private static final int N = new Random().nextInt();
    /**
     * array visitors of bank.
     */
    private Man[] mans = new Man[5];

    /**
     * constructor Bank.
     * @param workingTimes - WorkingTime[]
     * @param mans - Man[]
     */
    public Bank(WorkingTime[] workingTimes, Man[] mans) {
        this.workingTimes = workingTimes;
        this.mans = mans;
    }

    /**
     * fill array mans.
     */
    public void fillMans() {
        /*
        for (int i = 0; i < this.mans.length; i++) {
            int entryTime = new Random().nextInt(10) + 8;
            int exitTime = entryTime + new Random().nextInt(19 - entryTime);
            mans[i] = new Man(entryTime, exitTime);
        }
        */
        this.mans[0] = new Man(8, 20);
        this.mans[1] = new Man(10, 15);
        this.mans[2] = new Man(9, 18);
        this.mans[3] = new Man(16, 19);
        this.mans[4] = new Man(11, 16);
    }

    /**
     * fill array workingTimes.
     */
    public void fillWorkingTimes() {
        for (int j = 0; j < workingTimes.length; j++) {
            int time = j + 8;
            this.workingTimes[j] = new WorkingTime(0, time);
        }
    }

    /**
     * reads the flow of people.
     *
     * @return workingTimes - WorkingTime[]
     */
    public WorkingTime[] flowPeople() {
        fillWorkingTimes();
        fillMans();
        for (int i = 0; i < this.workingTimes.length; i++) {
            int count = 0;
            for (int j = 0; j < this.mans.length; j++) {
                int[] times = this.mans[j].timeInTheBank();
                for (int k = 0; k < times.length; k++) {
                    if (this.workingTimes[i].getTime() == times[k]) {
                        count++;
                    }
                }
            }
            this.workingTimes[i].setCount(count);
        }
        return this.workingTimes;
    }

    /**
     * reads time when max flow.
     *
     * @return array - time when max flow
     */
    public WorkingTime[] maxFlow() {
        flowPeople();
        WorkingTime[] result = new WorkingTime[this.workingTimes.length];
        int position = 0;
        int max = 0;
        for (int i = 0; i < this.workingTimes.length; i++) {
            for (int j = 0; j < this.workingTimes.length; j++) {
                if (this.workingTimes[i].getCount() > this.workingTimes[j].getCount()
                        && this.workingTimes[i].getCount() > max) {
                    max = this.workingTimes[i].getCount();
                }
            }
        }
        for (int j = 0; j < this.workingTimes.length; j++) {
            if (this.workingTimes[j].getCount() == max) {
                result[position++] = this.workingTimes[j];
            }
        }
        System.out.println(max);
        return Arrays.copyOf(result, position);
    }

    /**
     * chows on the console.
     */
    public void show() {
        WorkingTime[] showArray = maxFlow();
        for (int i = 0; i < this.workingTimes.length; i++) {
            System.out.printf("[%s:%s]", this.workingTimes[i].getTime(), "00");
        }
        System.out.println();
        for (int i = 0; i < this.workingTimes.length; i++) {
            System.out.printf("[ %s  ]", this.workingTimes[i].getCount());
        }
        System.out.println();
        for (int i = 0; i < showArray.length; i++) {
            System.out.printf("[%s:%s]", showArray[i].getTime(), "00");
        }
        System.out.println();
        for (int i = 0; i < showArray.length; i++) {
            System.out.printf("[ %s  ]", showArray[i].getCount());
        }
    }
}
