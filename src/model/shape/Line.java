package hk.edu.polyu.comp.comp2021.clevis.model.shape;

import hk.edu.polyu.comp.comp2021.clevis.view.View;

import java.awt.*;
import java.awt.geom.Line2D;

/// Line shape
public class Line extends Shape {
    final private Coordinate destinationCoordinate;
    final private double m;

    /**
     * Constructor for rectangle
     * @param name: unique name of the rectangle
     * @param start_x: the x coordinate of where the {@code Line} is to be placed
     * @param start_y: the y coordinate of where the {@code Line} is to be placed
     * @param destination_x: the x coordinate of where the {@code Line} is directed to
     * @param destination_y: the y coordinate of where the {@code Line} is directed to
     */
    public Line (String name, double start_x, double start_y, double destination_x, double destination_y) {
        super(name, start_x, start_y);
        this.destinationCoordinate = new Coordinate(destination_x, destination_y);
        this.m = (this.getDestination_y() - this.getY()) / (this.getDestination_x() - this.getX());
    }

    @Override
    public void setPosition(Coordinate newCoordinate) {
        super.setPosition(newCoordinate);
        this.destinationCoordinate.setX(this.getDestination_x() + newCoordinate.getX());
        this.destinationCoordinate.setY(this.getDestination_y() + newCoordinate.getY());
    }

    /**
     * Get width of the rectangle
     * @return {@code destination_x}
     */
    public double getDestination_x () {return this.destinationCoordinate.getX();}

    /**
     * Get width of the rectangle
     * @return {@code destination_y}
     */
    public double getDestination_y () {return this.destinationCoordinate.getY();}

    @Override
    public Boundingbox getBoundingbox() {
        return new Boundingbox(
                Math.min(this.getX(), this.getDestination_x()),
                Math.max(this.getY(), this.getDestination_y()),
                Math.abs(this.getX() - this.getDestination_x()),
                Math.abs(this.getY() - this.getDestination_y()));
    }

    @Override
    public void printInfo(View view) {
        view.displayMessage("Line: " + this.getName() + " " + this.getX() + " " + this.getY()
                + " " + this.getDestination_x() + " " + this.getDestination_y());
    }

    @Override
    protected double calculateMinDistanceTo(Coordinate point) {
        if (this.getX() == this.getDestination_x())
            return Math.abs(point.getX() - this.getX());

        double C = this.getY() - m * this.getX(),
                numerator = Math.abs(m*point.getX() - point.getY() + C),
                denominator = Math.sqrt(Math.pow(m, 2) + 1);

        return numerator/denominator;
    }

    @Override
    public void drawShape(Graphics2D g2d) {
        double x1 = getX();
        double y1 = getY();
        double x2 = destinationCoordinate.getX();
        double y2 = destinationCoordinate.getY();

        g2d.setColor(new Color(FILL_RED, FILL_GREEN, FILL_BLUE));
        g2d.setStroke(new BasicStroke(STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.draw(new Line2D.Double(x1, y2, x2, y1));

        double midX = (x1 + x2) / 2;
        double midY = (y1 + y2) / 2;

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("SansSerif", Font.BOLD, FONT_SIZE));
        g2d.drawString(getName(), (float)midX + NAME_ADJUSTMENT_X, (float)midY + NAME_ADJUSTMENT_Y);
    }

    private static final int FILL_RED = 0;
    private static final int FILL_GREEN = 140;
    private static final int FILL_BLUE = 0;

    private static final float STROKE_WIDTH = 3.0f;

    private static final int FONT_SIZE = 11;

    private static final int NAME_ADJUSTMENT_X = 4;
    private static final int NAME_ADJUSTMENT_Y = -4;
}
