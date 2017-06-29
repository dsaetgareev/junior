package ru.job4j.bomberman;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import static ru.job4j.bomberman.BoardGraph.HEIGHT;
import static ru.job4j.bomberman.BoardGraph.SCALE;
import static ru.job4j.bomberman.BoardGraph.WIDTH;

/**
 * Frame.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 19.06.2017
 * @version 1.0
 */
public class Frame {
    /**
     * list of Concrete.
     */
    private ArrayList<Concrete> frame = new ArrayList<>();
    /**
     * Random.
     */
    private Random rn = new Random();

    /**
     * constructor.
     */
    public Frame() {
        fillConcrete();
    }

    /**
     * gets list of frame.
     * @return - this frame
     */
    public ArrayList<Concrete> getFrame() {
        return this.frame;
    }

    /**
     * fills concrete.
     */
    public void fillConcrete() {
        for (int i = 0; i < 20; i++) {
            this.frame.add(new Concrete((SCALE * 2) + this.rn.nextInt(WIDTH) * SCALE,
                    (SCALE * 2) + this.rn.nextInt(HEIGHT) * SCALE, false));
            this.frame.add(new Concrete((SCALE * 2) + this.rn.nextInt(WIDTH) * SCALE,
                    (SCALE * 2) + this.rn.nextInt(HEIGHT) * SCALE, true));
        }
        for (int j = 0; j < HEIGHT; j++) {
            this.frame.add(new Concrete(0, j * SCALE, false));
            this.frame.add(new Concrete((WIDTH - 1) * SCALE, j * SCALE, false));
        }
        for (int k = 0; k < WIDTH; k++) {
            this.frame.add(new Concrete(k * SCALE, 0, false));
            this.frame.add(new Concrete(k * SCALE, (HEIGHT - 1) * SCALE, false));
        }
    }

    /**
     * drws frame.
     * @param g - Graphics
     */
    public void drawFrame(Graphics g) {
        for (Concrete cn : this.frame) {
            if (!cn.getDetonated()) {
                g.setColor(Color.PINK);
                g.fillRect(cn.getX(), cn.getY(), SCALE, SCALE);
            }
            if (cn.getDetonated()) {
                g.setColor(Color.red);
                g.fillRect(cn.getX(), cn.getY(), SCALE, SCALE);
            }
        }
    }
}
