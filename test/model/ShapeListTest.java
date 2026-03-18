package hk.edu.polyu.comp.comp2021.clevis.model;

import hk.edu.polyu.comp.comp2021.clevis.enums.Errors;
import hk.edu.polyu.comp.comp2021.clevis.model.shape.Line;
import hk.edu.polyu.comp.comp2021.clevis.model.shape.Rectangle;
import hk.edu.polyu.comp.comp2021.clevis.model.shape.Shape;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShapeListTest {
    private ShapeList shapeList = ShapeList.getInstance();
    private Rectangle testRectangle = new Rectangle("R1", 0, 0, 5, 7);
    private Line testLine = new Line("L1", -20, -50, 80, 60);

    @Test
    public void testAddShape(){
        shapeList.clear();
        shapeList.addShape(testRectangle);
        assertEquals(testRectangle, shapeList.getShape("R1"));
    }

    @Test
    public void testAddShapeWrongName(){
        shapeList.clear();
        shapeList.addShape(testRectangle);
        try {
            shapeList.addShape(testRectangle);
        } catch (Exception e) {
            assert true;
            return;
        }
        assert false;
//        assertThrows(Errors.REGISTERED_NAME.getMessage(), shapeList.addShape(testRectangle));
    }

    @Test
    public void testAddIndex() {
        shapeList.clear();
        shapeList.addShape(testRectangle);
        shapeList.addShape(testLine, 0);
        assertEquals(0, shapeList.getIndex(testLine));
    }

    @Test
    public void testRemove() {
        shapeList.clear();
        shapeList.addShape(testLine);
        shapeList.removeShape(testLine);
        assert true;
    }

    @Test
    public void testRemoveAll() {
        shapeList.clear();
        Shape[] shapes = {testRectangle};
        shapeList.removeAll(shapes);
        assert true;
    }

    @Test
    public void testInsertAll() {
        shapeList.clear();
        Shape[] shapes = {testRectangle, testLine};
        shapeList.insertAll(shapes);
        assertEquals(2, shapeList.getShapes().length);
    }

    @Test
    public void testGetShapesWithNames() {
        shapeList.clear();
        Shape[] shapes = {testRectangle, testLine};
        shapeList.insertAll(shapes);
        String[] names = {"R1", "L1"};
        assertEquals(2, shapeList.getShapes(names).length);
    }
}