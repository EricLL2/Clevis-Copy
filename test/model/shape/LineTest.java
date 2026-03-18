package hk.edu.polyu.comp.comp2021.clevis.model.shape;

import hk.edu.polyu.comp.comp2021.clevis.view.CommandView;
import hk.edu.polyu.comp.comp2021.clevis.view.GuiView;
import hk.edu.polyu.comp.comp2021.clevis.view.View;
import org.junit.Test;
import static org.junit.Assert.*;

public class LineTest {
    private Line testLine = new Line("L1", 10.0, 10.0, 30.0, 20.0);;
    private final double DELTA = 1e-9;

    @Test
    public void testConstructorAndGetters() {
        assertEquals("L1", testLine.getName());
        assertEquals(10.0, testLine.getX(), DELTA);
        assertEquals(10.0, testLine.getY(), DELTA);
        assertEquals(30.0, testLine.getDestination_x(), DELTA);
        assertEquals(20.0, testLine.getDestination_y(), DELTA);
    }

    @Test
    public void testGetBoundingbox_Diagonal() {
        Boundingbox expectedBB = new Boundingbox(10.0, 20.0, 20.0, 10.0);
        Boundingbox resultBB = testLine.getBoundingbox();
        assertEquals(expectedBB.getCoordinate().getX(), resultBB.getCoordinate().getX(), DELTA);
        assertEquals(expectedBB.getCoordinate().getY(), resultBB.getCoordinate().getY(), DELTA);
        assertEquals(expectedBB.getWidth(), resultBB.getWidth(), DELTA);
        assertEquals(expectedBB.getHeight(), resultBB.getHeight(), DELTA);
    }

    @Test
    public void testGetBoundingbox_ReverseDiagonal() {
        Line reverseLine = new Line("L2", 30.0, 20.0, 10.0, 10.0);
        Boundingbox expectedBB = new Boundingbox(10.0, 20.0, 20.0, 10.0);
        Boundingbox resultBB = reverseLine.getBoundingbox();
        assertEquals(expectedBB.getCoordinate().getX(), resultBB.getCoordinate().getX(), DELTA);
        assertEquals(expectedBB.getCoordinate().getY(), resultBB.getCoordinate().getY(), DELTA);
        assertEquals(expectedBB.getWidth(), resultBB.getWidth(), DELTA);
        assertEquals(expectedBB.getHeight(), resultBB.getHeight(), DELTA);
    }

    @Test
    public void testGetBoundingbox_Vertical() {
        Line verticalLine = new Line("LV", 5.0, 5.0, 5.0, 15.0);
        Boundingbox expectedBB = new Boundingbox(5.0, 15.0, 0.0, 10.0);
        Boundingbox resultBB = verticalLine.getBoundingbox();
        assertEquals(expectedBB.getCoordinate().getX(), resultBB.getCoordinate().getX(), DELTA);
        assertEquals(expectedBB.getCoordinate().getY(), resultBB.getCoordinate().getY(), DELTA);
        assertEquals(expectedBB.getWidth(), resultBB.getWidth(), DELTA);
        assertEquals(expectedBB.getHeight(), resultBB.getHeight(), DELTA);
    }

    @Test
    public void testGetBoundingbox_Horizontal() {
        Line horizontalLine = new Line("LH", 5.0, 5.0, 15.0, 5.0);
        Boundingbox expectedBB = new Boundingbox(5.0, 5.0, 10.0, 0.0);
        Boundingbox resultBB = horizontalLine.getBoundingbox();
        assertEquals(expectedBB.getCoordinate().getX(), resultBB.getCoordinate().getX(), DELTA);
        assertEquals(expectedBB.getCoordinate().getY(), resultBB.getCoordinate().getY(), DELTA);
        assertEquals(expectedBB.getWidth(), resultBB.getWidth(), DELTA);
        assertEquals(expectedBB.getHeight(), resultBB.getHeight(), DELTA);
    }

    @Test
    public void testSetPosition() {
        Coordinate moveBy = new Coordinate(5.0, 5.0);
        testLine.setPosition(moveBy);
        assertEquals(15.0, testLine.getX(), DELTA);
        assertEquals(15.0, testLine.getY(), DELTA);
        assertEquals(35.0, testLine.getDestination_x(), DELTA);
        assertEquals(25.0, testLine.getDestination_y(), DELTA);
    }

    @Test
    public void testMinDistance_OnLine() {
        Coordinate point = new Coordinate(14.0, 12.0);
        assertEquals(0.0, testLine.calculateMinDistanceTo(point), DELTA);
        assertTrue(testLine.hasPoint(point));
    }

    @Test
    public void testMinDistance_SimpleCase() {
        Line horizontalLine = new Line("H", 0.0, 0.0, 10.0, 0.0);
        Coordinate point = new Coordinate(5.0, 5.0);
        assertEquals(5.0, horizontalLine.calculateMinDistanceTo(point), DELTA);
        assertFalse(testLine.hasPoint(point));
    }

    @Test
    public void testMinDistance_VerticalLine() {
        Line verticalLine = new Line("V", 5.0, 0.0, 5.0, 10.0);
        Coordinate point = new Coordinate(10.0, 5.0);
        assertEquals(5.0, verticalLine.calculateMinDistanceTo(point), DELTA);
    }

    @Test
    public void testMinDistance_VerticalEndpoint() {
        Line verticalLine = new Line("V", 5.0, 0.0, 5.0, 10.0);
        Coordinate point = new Coordinate(5.0, 15.0);
        assertEquals(0.0, verticalLine.calculateMinDistanceTo(point), DELTA);
    }

    @Test
    public void testHasName() {
        assertTrue(testLine.hasName("L1"));
        assertFalse(testLine.hasName("L2"));
    }

    @Test
    public void testPrintInfo() {
        testLine.printInfo(new View(new CommandView(), new GuiView()));
        assert true;
    }

    @Test
    public void testPrintInfo2() {
        testLine.printInfo(new View(new CommandView(), new GuiView()), 0);
        assert true;
    }

    @Test
    public void testDraw() {
        testLine.draw(new CircleTest.MyGraphics2D());
        assert true;
    }
}