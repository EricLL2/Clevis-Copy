package hk.edu.polyu.comp.comp2021.clevis.model.shape;

import hk.edu.polyu.comp.comp2021.clevis.view.CommandView;
import hk.edu.polyu.comp.comp2021.clevis.view.GuiView;
import hk.edu.polyu.comp.comp2021.clevis.view.View;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {
    private Rectangle testRectangle = new Rectangle("R1", 10.0, 10.0, 5.0, 5.0);
    private final double DELTA = 1e-9; // Tolerance for double comparison

    @Test
    public void testConstructorAndGetters() {
        assertEquals("R1", testRectangle.getName());
        assertEquals(10.0, testRectangle.getX(), DELTA);
        assertEquals(10.0, testRectangle.getY(), DELTA);
        assertEquals(5.0, testRectangle.getWidth(), DELTA);
        assertEquals(5.0, testRectangle.getHeight(), DELTA);
    }

    @Test
    public void testGetBoundingbox() {
        Boundingbox expectedBB = new Boundingbox(10.0, 10.0, 5.0, 5.0);
        Boundingbox resultBB = testRectangle.getBoundingbox();
        assertEquals(expectedBB.getCoordinate().getX(), resultBB.getCoordinate().getX(), DELTA);
        assertEquals(expectedBB.getCoordinate().getY(), resultBB.getCoordinate().getY(), DELTA);
        assertEquals(expectedBB.getWidth(), resultBB.getWidth(), DELTA);
        assertEquals(expectedBB.getHeight(), resultBB.getHeight(), DELTA);
    }

    @Test
    public void testMinDistance_OnCorner() {
        Coordinate point = new Coordinate(10.0, 10.0);
        assertEquals(0.0, testRectangle.calculateMinDistanceTo(point), DELTA);
        assertTrue(testRectangle.hasPoint(point));
    }

    @Test
    public void testHasName() {
        assertTrue(testRectangle.hasName("R1"));
        assertFalse(testRectangle.hasName("R2"));
    }

    @Test
    public void testPrintInfo() {
        testRectangle.printInfo(new View(new CommandView(), new GuiView()));
        assert true;
    }

    @Test
    public void testPrintInfo2() {
        testRectangle.printInfo(new View(new CommandView(), new GuiView()), 0);
        assert true;
    }

    @Test
    public void testDraw() {
        testRectangle.draw(new CircleTest.MyGraphics2D());
        assert true;
    }
}