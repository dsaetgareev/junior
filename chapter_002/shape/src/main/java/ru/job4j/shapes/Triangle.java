package ru.job4j.shapes;

/**
 * class Triangle draw triangle.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 17.03.2017
 * @version 1.0
 */

public class Triangle implements Shape {
    /**
     * int height - height a triangle.
     */
    private int height;

    /**
     * Constructor Triangle(int height).
     * @param height - height a triangle
     */
    public Triangle(int height) {
        this.height = height;
    }
    /**
     * String pic().
     * @return symbol - String
     */
    @Override
    public String pic() {
        return " ^";
    }
    /**
     * void draw() - draw Shape.
     * @return triangle - String
     */
    @Override
    public String draw() {
        StringBuilder build = new StringBuilder();
        for (int i = 1; i <= this.height; i++) {
            if ((this.height - i) > 0) {
                for (int j = 0; j < (this.height - i); j++) {
                    build.append(" ");
                }
            }
            for (int k = 0; k < i; k++) {
                if (k == (i - 1)) {
                    build.append(this.pic() + "\n");
                } else {
                    build.append(this.pic());
                }
            }
        }
        return build.toString();
    }
}