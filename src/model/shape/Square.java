package hk.edu.polyu.comp.comp2021.clevis.model.shape;

import hk.edu.polyu.comp.comp2021.clevis.view.View;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/// Square shape
public class Square extends Shape{
    final private double length;
    /**
     * Constructor for rectangle
     * @param name: unique name of the rectangle
     * @param start_x: the x coordinate of where the {@code Rectangle} is to be placed
     * @param start_y: the y coordinate of where the {@code Rectangle} is to be placed
     * @param length: the width of the {@code Rectangle}
     */
    public Square(String name, double start_x, double start_y, double length) {
        super(name, start_x, start_y);
        this.length = length;
    }

    @Override
    public Boundingbox getBoundingbox() {
        return new Boundingbox(this.getX(), this.getY(), this.getLength(), this.getLength());
    }

    @Override
    public void printInfo(View view) {
        view.displayMessage("Square: " + this.getName() + " " + this.getX() + " " + this.getY()
                + " " + this.getLength());
    }

    @Override
    protected double calculateMinDistanceTo(Coordinate point) {
        return new Rectangle(null, this.getX(), this.getY(), this.getLength(), this.getLength())
                .calculateMinDistanceTo(point);
    }

    /**
     * Get length of the square
     *
     * @return {@code length}
     */
    public double getLength() {return this.length;}

    @Override
    public void drawShape(Graphics2D g2d) {
        Rectangle2D.Double rect =
                new Rectangle2D.Double(this.getX(), this.getY(), this.getLength(), this.getLength());

        g2d.setColor(new Color(FILL_RED, FILL_GREEN, FILL_BLUE, FILL_ALPHA));
        g2d.fill(rect);

        g2d.setColor(new Color(BORDER_RED, BORDER_GREEN, BORDER_BLUE));
        g2d.setStroke(new BasicStroke(BORDER_THICKNESS));
        g2d.draw(rect);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("SansSerif", Font.BOLD, FONT_SIZE));
        g2d.drawString(getName(), (float)(getX() + NAME_ADJUSTMENT_X), (float)(getY() + NAME_ADJUSTMENT_Y));
    }

    private static final int FILL_RED = 180;
    private static final int FILL_GREEN = 100;
    private static final int FILL_BLUE = 255;
    private static final int FILL_ALPHA = 100;

    private static final int BORDER_RED = 120;
    private static final int BORDER_GREEN = 0;
    private static final int BORDER_BLUE = 200;

    private static final float BORDER_THICKNESS = 3.0f;

    private static final int FONT_SIZE = 13;

    private static final int NAME_ADJUSTMENT_X = 6;
    private static final int NAME_ADJUSTMENT_Y = 16;
}
