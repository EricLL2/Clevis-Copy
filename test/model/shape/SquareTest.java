package hk.edu.polyu.comp.comp2021.clevis.model.shape;

import hk.edu.polyu.comp.comp2021.clevis.view.CommandView;
import hk.edu.polyu.comp.comp2021.clevis.view.GuiView;
import hk.edu.polyu.comp.comp2021.clevis.view.View;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {
    private Square testSquare = new Square("S1", 10.0, 10.0, 5.0);
    private final double DELTA = 1e-9; // Tolerance for double comparison

    @Test
    public void testConstructorAndGetters() {
        assertEquals("S1", testSquare.getName());
        assertEquals(10.0, testSquare.getX(), DELTA);
        assertEquals(10.0, testSquare.getY(), DELTA);
        assertEquals(5.0, testSquare.getLength(), DELTA);
    }

    @Test
    public void testGetBoundingbox() {
        Boundingbox expectedBB = new Boundingbox(10.0, 10.0, 5.0, 5.0);
        Boundingbox resultBB = testSquare.getBoundingbox();
        assertEquals(expectedBB.getCoordinate().getX(), resultBB.getCoordinate().getX(), DELTA);
        assertEquals(expectedBB.getCoordinate().getY(), resultBB.getCoordinate().getY(), DELTA);
        assertEquals(expectedBB.getWidth(), resultBB.getWidth(), DELTA);
        assertEquals(expectedBB.getHeight(), resultBB.getHeight(), DELTA);
    }

    @Test
    public void testMinDistance_OnCorner() {
        Coordinate point = new Coordinate(10.0, 10.0);
        assertEquals(0.0, testSquare.calculateMinDistanceTo(point), DELTA);
        assertTrue(testSquare.hasPoint(point));
    }

    @Test
    public void testHasName() {
        assertTrue(testSquare.hasName("S1"));
        assertFalse(testSquare.hasName("S2"));
    }

    @Test
    public void testPrintInfo() {
        testSquare.printInfo(new View(new CommandView(), new GuiView()));
        assert true;
    }

    @Test
    public void testPrintInfo2() {
        testSquare.printInfo(new View(new CommandView(), new GuiView()), 0);
        assert true;
    }

    @Test
    public void testDraw() {
        testSquare.draw(new CircleTest.MyGraphics2D());
        assert true;
    }
}