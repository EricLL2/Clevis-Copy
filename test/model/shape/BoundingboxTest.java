package hk.edu.polyu.comp.comp2021.clevis.model.shape;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoundingboxTest {
    @Test
    public void testConstructorAndGetters() {
        Boundingbox boxA = new Boundingbox(10.0, 10.0, 20.0, 10.0);
        assertEquals(20.0, boxA.getWidth(), 1e-9);
        assertEquals(10.0, boxA.getHeight(), 1e-9);
        assertEquals(10.0, boxA.getCoordinate().getX(), 1e-9);
        assertEquals(10.0, boxA.getCoordinate().getY(), 1e-9);
    }

    @Test
    public void testNonIntersecting_SeparatedX() {
        Boundingbox boxA = new Boundingbox(10.0, 10.0, 20.0, 10.0);
        Boundingbox boxB = new Boundingbox(40.0, 10.0, 10.0, 10.0);
        assertFalse(boxA.intersects(boxB));
        assertFalse(boxB.intersects(boxA));
    }

    @Test
    public void testNonIntersecting_SeparatedY() {
        Boundingbox boxA = new Boundingbox(10.0, 10.0, 20.0, 10.0);
        Boundingbox boxC = new Boundingbox(10.0, 30.0, 20.0, 10.0);
        assertFalse(boxA.intersects(boxC));
        assertFalse(boxC.intersects(boxA));
    }

    @Test
    public void testIntersecting_Overlap() {
        Boundingbox boxA = new Boundingbox(10.0, 10.0, 20.0, 10.0);
        Boundingbox boxD = new Boundingbox(20.0, 15.0, 20.0, 10.0);
        assertTrue(boxA.intersects(boxD));
        assertTrue(boxD.intersects(boxA));
    }

    @Test
    public void testIntersecting_Contained() {
        Boundingbox boxA = new Boundingbox(10.0, 10.0, 20.0, 10.0);
        Boundingbox boxE = new Boundingbox(5.0, 5.0, 30.0, 20.0);
        assertTrue(boxA.intersects(boxE));
        assertTrue(boxE.intersects(boxA));
    }

    @Test
    public void testNonIntersecting_TouchingEdgeX() {
        Boundingbox boxA = new Boundingbox(10.0, 10.0, 20.0, 10.0);
        Boundingbox boxF = new Boundingbox(30.0, 10.0, 10.0, 10.0);
        assertFalse(boxA.intersects(boxF));
        assertFalse(boxF.intersects(boxA));
    }

    @Test
    public void testNonIntersecting_TouchingEdgeY() {
        Boundingbox boxA = new Boundingbox(10.0, 10.0, 20.0, 10.0);
        Boundingbox boxG = new Boundingbox(10.0, 20.0, 20.0, 10.0);
        assertFalse(boxA.intersects(boxG));
        assertFalse(boxG.intersects(boxA));
    }

    @Test
    public void testIntersecting_Identity() {
        Boundingbox boxA = new Boundingbox(10.0, 10.0, 20.0, 10.0);
        Boundingbox boxH = new Boundingbox(10.0, 10.0, 20.0, 10.0);
        assertTrue(boxA.intersects(boxH));
    }

    @Test
    public void testIntersecting_NegativeCoordinates() {
        Boundingbox boxI = new Boundingbox(-20.0, -20.0, 10.0, 10.0);
        Boundingbox boxJ = new Boundingbox(-15.0, -15.0, 10.0, 10.0);

        assertTrue(boxI.intersects(boxJ));

        Boundingbox boxK = new Boundingbox(-100.0, -100.0, 10.0, 10.0);
        assertFalse(boxI.intersects(boxK));
    }
}