
/*
 *  Facade Pattern
 */
import java.util.*;
import java.io.*;
import java.lang.*;

// Interface representing a shape
interface Shape {
    void draw();
}

// Concrete implementation of Shape for Rectangle
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}

// Concrete implementation of Shape for Square
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}

// Concrete implementation of Shape for Circle
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}

// Facade class providing a simplified interface to the client
class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    // Constructor initializing shapes
    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    // Methods to draw specific shapes
    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }
}

// Client class demonstrating the usage of the Facade Pattern
public class FacadePattern {
    public static void main(String[] args) {
        // Creating an instance of the Facade
        ShapeMaker shapeMaker = new ShapeMaker();

        // Using the simplified interface to draw shapes
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
