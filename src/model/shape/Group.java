package hk.edu.polyu.comp.comp2021.clevis.model.shape;

import hk.edu.polyu.comp.comp2021.clevis.view.View;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/// A shape that combines multiple shapes.
public class Group extends Shape {
    final private Shape[] children;
    final private double maxWidth, maxHeight;

    /**
     * The default constructor for {@code Group} shape.
     *
     * @param name: the name of the new group.
     * @param children: the children of the shape.
     */
    public Group(String name, Shape[] children) {
        super(name, 0, 0);
        this.children = children;

        Boundingbox[] boundingboxes = this.getBoundingboxes();
        this.coordinate.setX(this.calculateMinX(boundingboxes));
        this.coordinate.setY(this.calculateMaxY(boundingboxes));
        this.maxWidth = this.calculateMaxHorizontal(boundingboxes) - this.getX();
        this.maxHeight =  this.getY() - this.calculateMaxVertical(boundingboxes);
    }

    @Override
    public Boundingbox getBoundingbox() {
        return new Boundingbox(this.getX(), this.getY(), this.maxWidth, this.maxHeight);
    }

    @Override
    public void setPosition(Coordinate newCoordinate) {
        super.setPosition(newCoordinate);
        for (Shape child: this.getChildren())
            child.setPosition(newCoordinate);
    }

    @Override
    public void printInfo(View view) {
        StringBuilder message = new StringBuilder("Group: " + this.getName());
        for (Shape child: this.getChildren())
            message.append(", ").append(child.getName());

        view.displayMessage(message.toString());
    }

    @Override
    public void printInfo(View view, int level) {
        String message = "  ".repeat(level) + "Group: " + this.getName();
        view.displayMessage(message);
        for (Shape child: this.getChildren())
            child.printInfo(view, level+1);
    }

    @Override
    protected double calculateMinDistanceTo(Coordinate point) {
        double minDistance = this.getChildren()[0].calculateMinDistanceTo(point);
        for (Shape child: this.getChildren())
            minDistance = Math.min(minDistance, child.calculateMinDistanceTo(point));

        return minDistance;
    }

    @Override
    public boolean hasName(String name) {
        if (super.hasName(name)) return true;

        for (Shape child: this.getChildren())
            if (child.hasName(name)) return true;

        return false;
    }

    /**
     * Get the children of the corresponding group of shapes.
     *
     * @return children of the shape.
     */
    public Shape[] getChildren() {
        return this.children;
    }

    private Boundingbox[] getBoundingboxes() {
        List<Boundingbox> boundingboxes = new ArrayList<>();
        for (Shape child: this.getChildren())
            boundingboxes.add(child.getBoundingbox());

        return boundingboxes.toArray(new Boundingbox[0]);
    }

    private double calculateMinX(Boundingbox[] boundingboxes) {
        double minX = boundingboxes[0].getCoordinate().getX();
        for (Boundingbox child: boundingboxes)
            minX = Math.min(minX, child.getCoordinate().getX());

        return minX;
    }

    private double calculateMaxY(Boundingbox[] boundingboxes) {
        double maxY = boundingboxes[0].getCoordinate().getY();
        for (Boundingbox child: boundingboxes)
            maxY = Math.max(maxY, child.getCoordinate().getY());

        return maxY;
    }

    private double calculateMaxHorizontal(Boundingbox[] boundingboxes) {
        double maxHorizontal = boundingboxes[0].getCoordinate().getX() + boundingboxes[0].getWidth();
        for (Boundingbox child: boundingboxes)
            maxHorizontal = Math.max(maxHorizontal, child.getCoordinate().getX() + child.getWidth());

        return maxHorizontal;
    }

    private double calculateMaxVertical(Boundingbox[] boundingboxes) {
        double maxVertical = boundingboxes[0].getCoordinate().getY() + boundingboxes[0].getHeight();
        for (Boundingbox child: boundingboxes)
            maxVertical = Math.min(maxVertical, child.getCoordinate().getY() - child.getHeight());

        return maxVertical;
    }

    @Override
    public void drawShape(Graphics2D g2d) {
        for (Shape child : children)
            child.draw(g2d);
    }
}
