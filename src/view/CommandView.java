package hk.edu.polyu.comp.comp2021.clevis.view;

import hk.edu.polyu.comp.comp2021.clevis.model.shape.*;

/// A class for the view to display on the user's screen
public class CommandView implements IView {
    @Override
    public void displayBoundingbox(Boundingbox boundingbox) {
        System.out.println("Boundingbox: " + boundingbox.getCoordinate().getX()
                + " " + boundingbox.getCoordinate().getY() + " " + boundingbox.getWidth() + " "
                + boundingbox.getHeight());
    }

    @Override
    public void displayName(Shape shape) {
        System.out.println(shape.getName());
    }

    @Override
    public void displayTrue() {
        System.out.println("Yes");
    }

    @Override
    public void displayFalse() {
        System.out.println("No");
    }

    @Override
    public void displayMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    @Override
    public void displayPartialLine(String message) {
        System.out.print(message);
    }
}
