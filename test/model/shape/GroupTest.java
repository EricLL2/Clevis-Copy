package hk.edu.polyu.comp.comp2021.clevis.model.shape;

import hk.edu.polyu.comp.comp2021.clevis.view.CommandView;
import hk.edu.polyu.comp.comp2021.clevis.view.GuiView;
import hk.edu.polyu.comp.comp2021.clevis.view.View;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroupTest {
    private Rectangle testRectangle = new Rectangle("R1", 10.0, 10.0, 5.0, 5.0);
    private Square testSquare = new Square("S1", 10.0, 10.0, 5.0);
    private Line testLine = new Line("L1", 10.0, 10.0, 5.0, 5.0);
    private Shape[] testShapes = {testRectangle, testSquare, testLine};
    private Group testGroup = new Group("G1", testShapes);
    private final double DELTA = 1e-9; // Tolerance for double comparison

    @Test
    public void testConstructorAndGetters() {
        assertEquals("G1", testGroup.getName());
    }

    @Test
    public void testGetBoundingbox() {
        Boundingbox expectedBB = new Boundingbox(5, 10.0, 10, 5.0);
        Boundingbox resultBB = testGroup.getBoundingbox();
        assertEquals(expectedBB.getCoordinate().getX(), resultBB.getCoordinate().getX(), DELTA);
        assertEquals(expectedBB.getCoordinate().getY(), resultBB.getCoordinate().getY(), DELTA);
        assertEquals(expectedBB.getWidth(), resultBB.getWidth(), DELTA);
        assertEquals(expectedBB.getHeight(), resultBB.getHeight(), DELTA);
    }

    @Test
    public void testSetPosition() {
        Coordinate coordinate = new Coordinate(5, 5);
        testGroup.setPosition(coordinate);
        Boundingbox expectedBB = new Boundingbox(10, 15, 10, 5);
        Boundingbox resultBB = testGroup.getBoundingbox();
        assertEquals(expectedBB.getCoordinate().getX(), resultBB.getCoordinate().getX(), DELTA);
        assertEquals(expectedBB.getCoordinate().getY(), resultBB.getCoordinate().getY(), DELTA);
        assertEquals(expectedBB.getWidth(), resultBB.getWidth(), DELTA);
        assertEquals(expectedBB.getHeight(), resultBB.getHeight(), DELTA);
    }

    @Test
    public void testMinDistance_OnCorner() {
        Coordinate point = new Coordinate(10.0, 10.0);
        assertEquals(0.0, testGroup.calculateMinDistanceTo(point), DELTA);
        assertTrue(testGroup.hasPoint(point));
    }

    @Test
    public void testHasName() {
        assertTrue(testGroup.hasName("G1"));
        assertTrue(testGroup.hasName("R1"));
        assertTrue(testGroup.hasName("L1"));
        assertTrue(testGroup.hasName("S1"));
        assertFalse(testGroup.hasName("C2"));
    }

    @Test
    public void testGetChildren() {
        assertEquals(testGroup.getChildren().length, 3);
    }

    @Test
    public void testPrintInfo() {
        testGroup.printInfo(new View(new CommandView(), new GuiView()));
        assert true;
    }

    @Test
    public void testPrintInfo2() {
        testGroup.printInfo(new View(new CommandView(), new GuiView()), 0);
        assert true;
    }

    @Test
    public void testDraw() {
            testGroup.draw(new CircleTest.MyGraphics2D());
            assert true;
    }
}