/*
 *  Builder Pattern
 *  
 *  Uses:
 * 
 *  Interface Item for creating food items
 *  Interface Package for packing food item
 *  Concrete Classes : Wrapper and Bottle implementing Package
 *  Abstract Super Classes : Burger , Drink
 *  Sub Classes : Veg Burger, Non Veg Burger, Cold Drink and Hot Drink
 *  Represent a complex Object (combination of objects of food items) using Meal Class
 *  Builder Class : MealBuilder to build complex Objects
 *  Main Class : To create Builder to create complex objects
 * 
 */

import java.util.*;
import java.io.*;
import java.lang.*;

// Interface for food items
interface Item {
    public String name();

    public Package pack();

    public float price();
}

// Interface for packaging
interface Package {
    public String pack();
}

// Wrapper for burger
class Wrapper implements Package {
    @Override
    public String pack() {
        return "Wrapper";
    }
}

// Bottle for drinks
class Bottle implements Package {
    @Override
    public String pack() {
        return "Bottle";
    }
}

// Abstract Class Burger -> superclass of all types of burgers
abstract class Burger implements Item {
    @Override
    public Package pack() {
        return new Wrapper();
    }

    public abstract float price();
}

// Abstract Class Drink -> Superclass of all types of drinks
abstract class Drink implements Item {
    @Override
    public Package pack() {
        return new Bottle();
    }

    public abstract float price();
}

// Concrete Classes

// Burger -> Veg and Non Veg
class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 30.5f;
    }
}

class NonVegBurger extends Burger {
    @Override
    public String name() {
        return "Non Veg Burger";
    }

    @Override
    public float price() {
        return 40.5f;
    }
}

// Drinks -> Cold and Hot
class ColdDrink extends Drink {
    @Override
    public String name() {
        return "Cold Drink";
    }

    @Override
    public float price() {
        return 20.5f;
    }
}

class HotDrink extends Drink {
    @Override
    public String name() {
        return "Hot Drink";
    }

    @Override
    public float price() {
        return 21.5f;
    }
}

// Meal class composed of items
// Represent Complex Object using Simple Objects (Items)
class Meal {
    List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (Item it : items) {
            cost += it.price();
        }
        return cost;
    }

    public void displayItems() {
        for (Item it : items) {
            System.out.println("Item Name : " + it.name());
            System.out.println("Item Price : " + it.price());
            System.out.println("Item Packed with : " + it.pack().pack());
        }
    }
}

// Builder for creating complex objects (Meal)
class MealBuilder {
    public Meal vegMeal() {
        Meal m = new Meal();
        m.addItem(new VegBurger());
        m.addItem(new ColdDrink());
        return m;
    }

    public Meal nonVegMeal() {
        Meal m = new Meal();
        m.addItem(new NonVegBurger());
        m.addItem(new HotDrink());
        return m;
    }
}

public class BuilderPattern {
    public static void main(String args[]) throws Exception {
        MealBuilder ob = new MealBuilder();

        System.out.println();
        Meal veg = ob.vegMeal();
        System.out.println("Veg meal :");
        veg.displayItems();
        System.out.println("Total Price : " + veg.getCost());

        System.out.println();
        Meal nonveg = ob.nonVegMeal();
        System.out.println("Non Veg meal :");
        nonveg.displayItems();
        System.out.println("Total Price : " + nonveg.getCost());
        System.out.println();
    }
}
