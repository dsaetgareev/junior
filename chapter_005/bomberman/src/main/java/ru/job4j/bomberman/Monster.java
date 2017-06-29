package ru.job4j.bomberman;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import static ru.job4j.bomberman.BoardGraph.SCALE;


/**
 * Monster.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 19.06.2017
 * @version 1.0
 */
public class Monster extends GameObject {
    /**
     * x.
     */
    private int x;
    /**
     * y.
     */
    private int y;
    /**
     * direction.
     */
    private int direction;
    /**
     * frame.
     */
    private Frame frame;
    /**
     * list of monsters.
     */
    private ArrayList<Monster> monsters;
    /**
     * random.
     */
    private Random rn = new Random();


    /**
     * constructor.
     * @param x - x
     * @param y - y
     * @param frame - frame
     * @param monsters - monsters
     */
    public Monster(int x, int y, Frame frame, ArrayList<Monster> monsters) {
        super(x, y);
        this.x = x;
        this.y = y;
        this.direction = new Random().nextInt(4);
        this.frame = frame;
        this.monsters = monsters;
    }

    /**
     * gets x.
     * @return this.x
     */
    public int getX() {
        return this.x;
    }

    /**
     * gets y.
     * @return - this.y
     */
    public int getY() {
        return this.y;
    }

    /**
     * move.
     */
    public void move() {
        checkMonsters();
        if (this.direction == 0) {
            if (!isConcrete()) {
                this.y--;
            } else {
                this.y++;
                this.direction = rn.nextInt(4);
            }
        }
        if (this.direction == 1) {
            if (!isConcrete()) {
                this.x++;
            } else {
                this.x--;
                this.direction = rn.nextInt(4);
            }
        }
        if (this.direction == 2) {
            if (!isConcrete()) {
                this.y++;
            } else {
                this.y--;
                this.direction = rn.nextInt(4);
            }
        }
        if (this.direction == 3) {
            if (!isConcrete()) {
                this.x--;
            } else {
                this.x++;
                this.direction = rn.nextInt(4);
            }
        }
    }

    /**
     * checks is collision with concrete.
     * @return boolean is collision
     */
    public boolean isConcrete() {
        boolean result = false;
        for (Concrete concrete : this.frame.getFrame()) {
            if ((this.x > concrete.getX() - (SCALE - 1)) && (this.x < concrete.getX() + SCALE)
                    && (this.y > concrete.getY() - (SCALE - 1)) && (this.y < concrete.getY() + SCALE)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * checks for a collision with monsters.
     */
    public void checkMonsters() {
        for (Monster monster : this.monsters) {
            if (this.direction == 0) {
                if (Math.abs((this.x - monster.getX())) <= SCALE - 1 && this.y == monster.getY() + SCALE) {
                    this.direction = 2;
                    monster.moveRevers();
                    this.myWait(1000);
                }
            }
            if (this.direction == 1) {
                if (this.x == monster.getX() - SCALE && Math.abs((this.y - monster.getY())) <= SCALE - 1) {
                    this.direction = 3;
                    monster.moveRevers();
                    this.myWait(1000);
                    monster.myWait(1000);
                }
            }
            if (this.direction == 2) {
                if (Math.abs((this.x - monster.getX())) <= SCALE - 1 && this.y == monster.getY() - SCALE) {
                    this.direction = 0;
                    monster.moveRevers();
                    this.myWait(1000);
                    monster.myWait(1000);
                }
            }
            if (this.direction == 3) {
                if (this.x == monster.getX() + SCALE && Math.abs((this.y - monster.getY())) <= SCALE - 1) {
                    this.direction = 1;
                    monster.moveRevers();
                    this.myWait(1000);
                    monster.myWait(1000);
                }
            }
        }
    }

    /**
     * myWait().
     * @param l - long
     */
    public void myWait(long l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * revers move.
     */
    public void moveRevers() {
        if (this.direction == 0) {
            this.direction = 2;
        }
        if (this.direction == 1) {
            this.direction = 3;
        }
        if (this.direction == 2) {
            this.direction = 0;
        }
        if (this.direction == 3) {
            this.direction = 1;
        }
    }

    /**
     * draws monster.
     * @param g - Graphics
     */
    public void drawMonster(Graphics g) {
        g.setColor(Color.orange);
        g.fillOval(this.x, this.y, SCALE, SCALE);
    }
}
