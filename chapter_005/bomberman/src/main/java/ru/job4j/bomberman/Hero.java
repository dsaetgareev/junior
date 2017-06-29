package ru.job4j.bomberman;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static ru.job4j.bomberman.BoardGraph.SCALE;

/**
 * Hero of game.
 *
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 19.06.2017
 */
public class Hero extends GameObject {
    /**
     * x.
     */
    private int x;
    /**
     * y.
     */
    private int y;
    /**
     * frame.
     */
    private Frame frame;
    /**
     * list of monsters.
     */
    private ArrayList<Monster> monsters;
    /**
     * boolean dead.
     */
    private boolean dead;
    /**
     * list of bombs.
     */
    private ArrayList<Bomb> bombs = new ArrayList<>();

    /**
     * constructor.
     *
     * @param x        - x
     * @param y        - y
     * @param frame    - frame
     * @param monsters - monsters
     */
    public Hero(int x, int y, Frame frame, ArrayList<Monster> monsters) {
        super(x, y);
        this.x = x;
        this.y = y;
        this.frame = frame;
        this.monsters = monsters;
    }

    /**
     * getDead().
     *
     * @return - this.dead
     */
    public boolean getDead() {
        return this.dead;
    }

    /**
     * creates bomb.
     */
    public void createBomb() {
        this.bombs.add(new Bomb(this.x, this.y, this.monsters, this.frame.getFrame()));

    }

    /**
     * method of move.
     *
     * @param key - keyboard
     */
    public void move(int key) {
        this.checkConcrete(key);
        if (key == KeyEvent.VK_UP) {
            this.y -= 2;
        }
        if (key == KeyEvent.VK_RIGHT) {
            this.x += 2;
        }
        if (key == KeyEvent.VK_DOWN) {
            this.y += 2;
        }
        if (key == KeyEvent.VK_LEFT) {
            this.x -= 2;
        }
        if (key == KeyEvent.VK_B) {
            this.createBomb();
        }
    }

    /**
     * checks concrete.
     *
     * @param key - key
     */
    public void checkConcrete(int key) {
        int count = 0;
        for (Concrete concrete : this.frame.getFrame()) {
            if (isCheck(concrete)) {
                count++;
                this.revers(concrete);
                if (count == 2) {
                    revers2(key);
                }
            }
        }
    }

    /**
     * checks the collision.
     *
     * @param concrete - concrete
     * @return - boolean is collision
     */
    public boolean isCheck(Concrete concrete) {
        return ((this.x > concrete.getX() - (SCALE - 4)) && (this.y > concrete.getY() - (SCALE - 4))
                && (this.x < concrete.getX() + SCALE) && (this.y < concrete.getY() + SCALE));
    }

    /**
     * revers2.
     *
     * @param key - key
     */
    public void revers2(int key) {
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_RIGHT) {
            this.y -= 2;
            this.x -= 2;
        }
    }

    /**
     * revers.
     *
     * @param concrete - concrete
     */
    public void revers(Concrete concrete) {
        if (this.y > concrete.getY()) {
            this.y += 2;
        }
        if (this.x < concrete.getX()) {
            this.x -= 2;
        }
        if (this.y < concrete.getY()) {
            this.y -= 2;
        }
        if (this.x > concrete.getX()) {
            this.x += 2;
        }
    }

    /**
     * checks for a collision with a monster.
     */
    public void checkMonsters() {
        for (Monster monster : this.monsters) {
            if ((this.x > monster.getX() - (SCALE - 4)) && (this.x < monster.getX() + SCALE)
                    && (this.y > monster.getY() - (SCALE - 4)) && (this.y < monster.getY() + SCALE)) {
                this.dead = true;
            }
        }
    }

    /**
     * draws hero.
     *
     * @param g - Graphics
     */
    public void drawHero(Graphics g) {
        if (!this.dead) {
            g.setColor(Color.white);
            g.fillOval(this.x, this.y, SCALE - 4, SCALE - 4);
        } else {
            g.setColor(Color.white);
            g.fillOval(this.x + SCALE / 4, this.y + SCALE / 4, SCALE / 2, SCALE / 2);
        }

        for (int i = 0; i < this.bombs.size(); i++) {
            this.bombs.get(i).drawBomb(g);
            if (this.bombs.get(i).isDead()) {
                this.bombs.remove(i);
            }
        }

    }
}
