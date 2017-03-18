package ru.job4j.shapes;

/**
 * Class Paint contains main method and outputs to the console shape.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @since 17.03.2017
 * @version 1.0
 */
public class Paint {
    /**
     * private Shape shape.
     */
    private Shape shape;

    /**
     * Constructor Paint(Shape shape).
     * @param shape - Shape
     */
    public Paint(Shape shape) {
        this.shape = shape;
    }

    /**
     * init() - outputs to the console a shape.
     */
    public void init() {
        System.out.println(shape.draw());
    }

    /**
     * method main(String[] args).
     * @param args - String[]
     */
    public static void main(String[] args) {
        Shape shape = new Triangle(3);
        new Paint(shape).init();
        Shape shapeSquare = new Square(5);
        new Paint(shapeSquare).init();
    }
}
