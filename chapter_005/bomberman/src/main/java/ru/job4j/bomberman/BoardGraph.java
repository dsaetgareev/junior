package ru.job4j.bomberman;


import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BoardGraph.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 19.06.2017
 * @version 1.0
 */
public class BoardGraph extends JPanel implements ActionListener {
    /**
     * jFrame.
     */
    private  JFrame jFrame;
    /**
     * SCALE.
     */
    public static final int SCALE = 50;
    /**
     * WIDTH.
     */
    public static final int WIDTH = 15;
    /**
     * HEIGHT.
     */
    public static final int HEIGHT = 10;
    /**
     * timer.
     */
    private Timer timer = new Timer(15, this);
    /**
     * frame.
     */
    private Frame f = new Frame();
    /**
     * list of monsters.
     */
    private ArrayList<Monster> monsters = new ArrayList<>();

    /**
     * ExecutorsService.
     */
    private ExecutorService service = Executors.newFixedThreadPool(6);
    /**
     * hero.
     */
    private Hero hero = new Hero(101, (HEIGHT - 2) * SCALE, this.f, this.monsters);
    /**
     * KeyBoard.
     */
    private KeyBoard keyBoard = new KeyBoard(this.hero, this.service);

    /**
     * constructor.
     */
    public BoardGraph() {
        timer.start();
        fillMonsters();
        addKeyListener(keyBoard);
        setFocusable(true);
    }

    /**
     * fills monsters.
     */
    public void fillMonsters() {
        for (int i = 0; i < 5; i++) {
            this.monsters.add(new Monster(101, 51, this.f, this.monsters));
        }
    }

    /**
     * paint.
     * @param g - Graphics
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

        f.drawFrame(g);

        for (int x = 0; x < WIDTH * SCALE; x += SCALE) {
            g.setColor(Color.white);
            g.drawLine(x, 0, x, HEIGHT * SCALE);
        }

        for (int y = 0; y < HEIGHT * SCALE; y += SCALE) {
            g.setColor(Color.white);
            g.drawLine(0, y, WIDTH * SCALE, y);
        }

        this.hero.drawHero(g);

        for (Monster monster : this.monsters) {
            monster.drawMonster(g);
        }

    }

    /**
     * actionPerformed().
     * @param e - ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

        for (Monster monster : this.monsters) {
            service.submit(new MonstersThread(monster));
        }

        this.hero.checkMonsters();
        if (this.hero.getDead()) {
            service.shutdown();
            JOptionPane.showMessageDialog(null, "Вы проиграли!!!");
        }

    }

    /**
     * init game.
     */
    public void init() {
        this.jFrame = new JFrame("Bomberman");
        this.jFrame.setSize(this.WIDTH * this.SCALE, this.HEIGHT * this.SCALE);
        this.jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.jFrame.setResizable(false);
        this.jFrame.setLocationRelativeTo(null);
        this.jFrame.add(this);
        this.jFrame.setVisible(true);
    }
}
