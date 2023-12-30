
/*
 *  Prototype Pattern 
 */
import java.util.*;
import java.io.*;
import java.lang.*;

// Abstract class defining the prototype for creating shapes
abstract class Shape implements Cloneable {

    private String id;
    protected String type;

    // Abstract method for drawing the shape
    abstract void draw();

    // Getter method for retrieving the type of the shape
    public String getType() {
        return type;
    }

    // Getter method for retrieving the ID of the shape
    public String getId() {
        return id;
    }

    // Setter method for setting the ID of the shape
    public void setId(String id) {
        this.id = id;
    }

    // Clone method for creating a copy of the shape
    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}

// Concrete class representing a Rectangle
class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

// Concrete class representing a Square
class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

// Concrete class representing a Circle
class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

// Class responsible for caching and managing shapes
class ShapeCache {

    private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

    // Method for getting a cloned shape based on its ID
    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    // Method for loading predefined shapes into the cache
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}

// Main class demonstrating the usage of the Prototype Pattern
public class PrototypePattern {
    public static void main(String[] args) {
        // Load predefined shapes into the cache
        ShapeCache.loadCache();

        // Clone and display shapes
        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}
