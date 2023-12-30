/*
 * Factroy Pattern
 * 
 * Uses:
 * 
 * Interface -> To create Objects
 * Concrete Classes -> To specify Object types 
 * Factroy Class -> To create objects of concrete class
 * Main Class -> To create object of Factory Class and has the main method
 * 
 */

import java.util.*;
import java.io.*;
import java.lang.*;

// Interface for creating Objects
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

// Factory for creating objects
class ShapeFactory
{
    public Shape getShape(String type)
    {
        if(type==null) return null;
        else if(type.equalsIgnoreCase("Rectangle")) return new Rectangle();
        else if(type.equalsIgnoreCase("Square")) return new Square();
        else return new Triangle();
    }
}

// Main Class
public class FactoryPattern
{
    public static void main(String args[]) throws Exception
    {
        // Creating Objects from the factory
        ShapeFactory ob=new ShapeFactory();
        //get an object of Rectangle and call its draw method.
        Shape Shape1=ob.getShape("Rectangle");
        Shape1.draw();
        //get an object of Square and call its draw method.
        Shape Shape2=ob.getShape("Square");
        Shape2.draw();
        //get an object of Triangle and call its draw method.
        Shape Shape3=ob.getShape("Triangle");
        Shape3.draw();
    }
}