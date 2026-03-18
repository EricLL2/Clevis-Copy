package hk.edu.polyu.comp.comp2021.clevis.model.shape;

import hk.edu.polyu.comp.comp2021.clevis.view.View;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/// Circle shape
public class Circle extends Shape{
    final private double radius;

    /**
     * Constructor for circle
     * @param name: unique name of the circle
     * @param start_x: the x coordinate of where the {@code Circle} is to be placed
     * @param start_y: the y coordinate of where the {@code Circle} is to be placed
     * @param radius: the width of the {@code Circle}
     */
    public Circle (String name, double start_x, double start_y, double radius) {
        super(name, start_x, start_y);
        this.radius = radius;
    }

    /**
     * Get radius of the circle
     * @return {@code radius}
     */
    public double getRadius () {return radius;}

    @Override
    public Boundingbox getBoundingbox() {
        return new Boundingbox(this.getX()-this.getRadius(), this.getY()+this.getRadius(),
                this.getRadius()*2, this.getRadius()*2);
    }

    @Override
    public void printInfo(View view) {
        view.displayMessage("Circle: " + this.getName() + " " + this.getX() + " " + this.getY()
                + " " + this.getRadius());
    }

    @Override
    protected double calculateMinDistanceTo(Coordinate point) {
        return Math.abs(
                Math.sqrt(Math.pow(point.getX()-this.getX(), 2) + Math.pow(point.getY() - this.getY(), 2))
                - this.getRadius());
    }
    @Override
    public void drawShape(Graphics2D g2d) {
        double diameter = radius * 2;
        double left = getX() - radius;
        double top = getY() - radius;

        g2d.setColor(new Color(FILL_RED, FILL_GREEN, FILL_BLUE, FILL_ALPHA));
        g2d.fill(new Ellipse2D.Double(left, top, diameter, diameter));

        g2d.setColor(new Color(BORDER_RED, BORDER_GREEN, BORDER_BLUE));
        g2d.setStroke(new BasicStroke(BORDER_THICKNESS));
        g2d.draw(new Ellipse2D.Double(left, top, diameter, diameter));

        g2d.setColor(Color.RED);
        g2d.fillOval((int)(getX() - 2), (int)(getY() + 2), 4, 4);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, FONT_SIZE));
        g2d.drawString(getName(), (float)(getX() + radius + NAME_ADJUSTMENT_X), (float)(getY() + NAME_ADJUSTMENT_Y));
    }

    private static final int FILL_RED = 100;
    private static final int FILL_GREEN = 150;
    private static final int FILL_BLUE = 255;
    private static final int FILL_ALPHA = 80;

    private static final int BORDER_RED = 0;
    private static final int BORDER_GREEN = 70;
    private static final int BORDER_BLUE = 200;

    private static final float BORDER_THICKNESS = 2.0f;

    private static final int FONT_SIZE = 11;

    private static final int NAME_ADJUSTMENT_X = 4;
    private static final int NAME_ADJUSTMENT_Y = 5;

}
