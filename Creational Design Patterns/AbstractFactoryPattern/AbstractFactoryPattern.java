/*
 *  Abstract Factory Pattern
 *  
 *  Uses:
 *  
 *  Interface -> Shape for creating Objects
 *  Concrete Classes -> Rectangle Square Triangle are the types of objects
 *  Abstract Class -> AbstractFactory to define the Factory of factories
 *  Concrete Class -> FactroyProducer extends AbstractFactory to produce factories
 *  Main Class -> To create factories of each type. Each factory produces object of different type
 * 
 * 
 */
import java.util.*;
import java.io.*;
import java.lang.*;

// Interface for creating objects
interface Shape
{
    void draw();
}

// Concrete Classes -> Rectangle, Square, Triangle
// For Object of Type Rectangle
class Rectangle implements Shape
{
    @Override
    public void draw()
    {
        System.out.println("I am Rectangle");
    }
}

// For Object of Type Square
class Square implements Shape
{
    @Override
    public void draw()
    {
        System.out.println("I am Square");
    }
}

// For Object of Type Triangle
class Triangle implements Shape
{
    @Override
    public void draw()
    {
        System.out.println("I am Triangle");
    }
}

// Abstract class to get factories
abstract class AbstractFactory
{
    public abstract Shape getShape(String type);
}

// Factories of type Rectangle Square Triangle
class RectangleFactory extends AbstractFactory
{
    @Override
    public Shape getShape(String type)
    {
        if(type.equalsIgnoreCase("Rectangle"))
            return new Rectangle();
        else 
            return null;
    }
}
class SquareFactory extends AbstractFactory
{
    @Override
    public Shape getShape(String type)
    {
        if(type.equalsIgnoreCase("Square"))
            return new Square();
        else 
            return null;
    }
}
class TriangleFactory extends AbstractFactory
{
    @Override
    public Shape getShape(String type)
    {
        if(type.equalsIgnoreCase("Triangle"))
            return new Triangle();
        else
            return null;
    }
}

// Factory Producer 
class FactoryProducer
{
    public static AbstractFactory getFactory(int num)
    {
        if(num==1) return new RectangleFactory();
        else if(num==2) return new SquareFactory();
        else if(num==3) return new TriangleFactory();
        else return null;
    }
}


// Main Class
public class AbstractFactoryPattern {
    public static void main(String args[]) throws Exception
    {
        // Create Factories
        AbstractFactory factory1=FactoryProducer.getFactory(1);
        AbstractFactory factory2=FactoryProducer.getFactory(2);
        AbstractFactory factory3=FactoryProducer.getFactory(3);

        // Get Objects from each type of factory
        Shape shape1=factory1.getShape("Rectangle");
        Shape shape2=factory2.getShape("Square");
        Shape shape3=factory3.getShape("Triangle");

        // Object Methods
        shape1.draw();
        shape2.draw();
        shape3.draw();
    }
}
