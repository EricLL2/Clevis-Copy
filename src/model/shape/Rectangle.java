package hk.edu.polyu.comp.comp2021.clevis.model.shape;

import hk.edu.polyu.comp.comp2021.clevis.view.View;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/// Rectangle shape
public class Rectangle extends Shape{
    final private double width;
    final private double height;

    /**
     * Constructor for rectangle
     * @param name: unique name of the rectangle
     * @param start_x: the x coordinate of where the {@code Rectangle} is to be placed
     * @param start_y: the y coordinate of where the {@code Rectangle} is to be placed
     * @param width: the width of the {@code Rectangle}
     * @param height: the height of the {@code Rectangle}
     */
    public Rectangle(String name, double start_x, double start_y, double width, double height) {
        super(name, start_x, start_y);
        this.width = width;
        this.height = height;
    }

    /**
     * Get width of the rectangle
     * @return {@code width}
     */
    public double getWidth() {
        return width;
    }

    /**
     * Get height of the rectangle
     * @return {@code height}
     */
    public double getHeight() {
        return height;
    }

    @Override
    public Boundingbox getBoundingbox() {
        return new Boundingbox(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    @Override
    public void printInfo(View view) {
        view.displayMessage("Rectangle: " + this.getName() + " " + this.getX() + " " + this.getY()
                + " " + this.getWidth() + " " + this.getHeight());
    }

    @Override
    protected double calculateMinDistanceTo(Coordinate point) {
        Line topSide = new Line(null, this.getX(), this.getY() + this.getHeight(),
                this.getX() + this.getWidth(), this.getY() + this.getHeight());

        Line bottomSide = new Line(null, this.getX(), this.getY(),
                this.getX() + this.getWidth(), this.getY());

        Line leftSide = new Line(null, this.getX(), this.getY(),
                this.getX(), this.getY() + this.getHeight());

        Line rightSide = new Line(null, this.getX() + this.getWidth(), this.getY(),
                this.getX() + this.getWidth(), this.getY() + this.getHeight());

        return Math.min(
                Math.min(topSide.calculateMinDistanceTo(point), bottomSide.calculateMinDistanceTo(point)),
                Math.min(leftSide.calculateMinDistanceTo(point), rightSide.calculateMinDistanceTo(point)));
    }

    @Override
    public void drawShape(Graphics2D g2d) {
        Rectangle2D.Double rect = new Rectangle2D.Double(getX(), getY(), width, height);

        g2d.setColor(new Color(FILL_RED, FILL_GREEN, FILL_BLUE, FILL_ALPHA));
        g2d.fill(rect);

        g2d.setColor(new Color(BORDER_RED, BORDER_GREEN, BORDER_BLUE));
        g2d.setStroke(new BasicStroke(STROKE_WIDTH));
        g2d.draw(rect);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("SansSerif", Font.BOLD, FONT_SIZE));
        g2d.drawString(getName(), (float)(getX() + NAME_ADJUSTMENT_X), (float)(getY() + NAME_ADJUSTMENT_Y));
    }

    private static final int FILL_RED = 255;
    private static final int FILL_GREEN = 100;
    private static final int FILL_BLUE = 100;
    private static final int FILL_ALPHA = 90;

    private static final int BORDER_RED = 255;
    private static final int BORDER_GREEN = 0;
    private static final int BORDER_BLUE = 0;

    private static final float STROKE_WIDTH = 2.5f;
    private static final int FONT_SIZE = 12;

    private static final int NAME_ADJUSTMENT_X = 6;
    private static final int NAME_ADJUSTMENT_Y = 16;
}
