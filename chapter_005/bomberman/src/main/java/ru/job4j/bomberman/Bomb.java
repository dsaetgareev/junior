package ru.job4j.bomberman;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

import static ru.job4j.bomberman.BoardGraph.SCALE;

/**
 * Bomb.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 19.06.2017
 * @version 1.0
 */
public class Bomb extends GameObject {
    /**
     * x.
     */
    private int x;
    /**
     * y.
     */
    private int y;
    /**
     * start time.
     */
    private long start;
    /**
     * list of monsters.
     */
    private ArrayList<Monster> monsters;
    /**
     * frame.
     */
    private ArrayList<Concrete> frame;
    /**
     * is dead.
     */
    private boolean dead = false;

    /**
     * constructor.
     * @param x - x
     * @param y - y
     * @param monsters - monsters
     * @param frame - frame
     */
    public Bomb(int x, int y, ArrayList<Monster> monsters, ArrayList<Concrete> frame) {
        super(x, y);
        this.x = x;
        this.y = y;
        start = System.currentTimeMillis();
        this.monsters = monsters;
        this.frame = frame;
    }

    /**
     * gets x.
     * @return - super.getX()
     */
    @Override
    public int getX() {
        return super.getX();
    }

    /**
     * gets y.
     * @return - super.getY()
     */
    @Override
    public int getY() {
        return super.getY();
    }

    /**
     * is dead.
     * @return - boolean is dead
     */
    public boolean isDead() {
        return this.dead;
    }


    /**
     * boom.
     */
    public void boom() {

        for (int i = 0; i < this.monsters.size(); i++) {
            if ((this.x > this.monsters.get(i).getX() - 2 * SCALE) && (this.x < this.monsters.get(i).getX() + 2 * SCALE)
                    && (this.y > this.monsters.get(i).getY() - SCALE) && (this.y < this.monsters.get(i).getY() + SCALE)
                    || (this.x > this.monsters.get(i).getX() - SCALE) && (this.x < this.monsters.get(i).getX() + SCALE)
                            && (this.y > this.monsters.get(i).getY() - 2 * SCALE) && (this.y < this.monsters.get(i).getY() + 2 * SCALE)) {
                this.monsters.remove(i);
                System.out.println("There are still monsters: " + this.monsters.size());
            }
        }

        for (int i = 0; i < this.frame.size(); i++) {
            if ((this.x > this.frame.get(i).getX() - 2 * SCALE) && (this.x < this.frame.get(i).getX() + 2 * SCALE)
                    && (this.y > this.frame.get(i).getY() - SCALE) && (this.y < this.frame.get(i).getY() + SCALE)
                    && this.frame.get(i).getDetonated()
                    || (this.x > this.frame.get(i).getX() - SCALE) && (this.x < this.frame.get(i).getX() + SCALE)
                            && (this.y > this.frame.get(i).getY() - 2 * SCALE)
                            && (this.y < this.frame.get(i).getY() + 2 * SCALE) && this.frame.get(i).getDetonated()) {
                this.frame.remove(this.frame.get(i));
            }
        }
    }

    /**
     * draws bomb.
     * @param g - Graphics
     */
    public void drawBomb(Graphics g) {
        if ((System.currentTimeMillis() - this.start) < 1500) {
            g.setColor(Color.MAGENTA);
            g.fillOval(this.getX(), this.getY(), SCALE - 4, SCALE - 4);
        } else {
            if ((System.currentTimeMillis() - this.start) < 2500) {
                g.setColor(Color.orange);
                g.fillOval(this.getX() + SCALE / 4, this.getY() + SCALE / 4, SCALE / 2, SCALE / 2);
                g.drawLine(this.getX() - SCALE, this.getY() + SCALE / 2,
                        this.getX() + SCALE * 2, this.getY() + SCALE / 2);
                g.drawLine(this.getX() + SCALE / 2, this.getY() - SCALE,
                        this.getX() + SCALE / 2, this.getY() + SCALE * 2);
                this.boom();
            } else {
                this.dead = true;
            }
        }
    }
}
