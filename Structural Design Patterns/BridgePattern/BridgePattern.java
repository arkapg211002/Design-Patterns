/*
 *  Bridge Pattern
 */

// Interface for drawing circles
interface DrawAPI {
    void drawCircle(int radius, int x, int y);
}

// Concrete implementation of DrawAPI for drawing red circles
class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle [ color: red, radius: " + radius + ", x: " + x + ", y: " + y + "]");
    }
}

// Concrete implementation of DrawAPI for drawing green circles
class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle [ color: green, radius: " + radius + ", x: " + x + ", y: " + y + "]");
    }
}

// Abstraction class representing a shape
abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    // Abstract method for drawing a shape
    public abstract void draw();
}

// Concrete implementation of Shape for drawing circles
class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    // Implementing the draw method for circles
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}

// Demo class to test the Bridge Pattern
public class BridgePattern {
    public static void main(String[] args) {
        // Creating red and green circles
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(200, 200, 15, new GreenCircle());

        // Drawing red and green circles
        redCircle.draw();
        greenCircle.draw();
    }
}
