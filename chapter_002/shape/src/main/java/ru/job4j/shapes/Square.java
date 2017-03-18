package ru.job4j.shapes;

/**
 * class Square draw square.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 17.03.2017
 * @version 1.0
 */
public class Square implements Shape {
    /**
     * int height - height a square.
     */
    private int height;

    /**
     * Constructor Square(int height).
     * @param height - height a square
     */
    public Square(int height) {
        this.height = height;
    }
    /**
     * String pic().
     * @return symbol - String
     */
    @Override
    public String pic() {
        return "88";
    }
    /**
     * void draw() - draw Shape.
     */
    @Override
    public String draw() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.height; j++) {
                if (j == this.height - 1) {
                    builder.append(this.pic() + "\n");
                } else {
                    builder.append(this.pic());
                }
            }
        }
        return builder.toString();
    }
}
