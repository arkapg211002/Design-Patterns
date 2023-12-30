// Memento Pattern

import java.util.*;

// Memento class storing the state of the originator
class Memento {
    private String state;

    // Constructor to create a memento with a given state
    public Memento(String state) {
        this.state = state;
    }

    // Getter to get the state from the memento
    public String getState() {
        return state;
    }
}

// Originator class that creates and restores mementos
class Originator {
    private String state;

    // Setter to set the internal state
    public void setState(String state) {
        this.state = state;
    }

    // Getter to get the current state
    public String getState() {
        return state;
    }

    // Method to save the current state in a memento
    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    // Method to restore the state from a memento
    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}

// Caretaker class responsible for keeping track of mementos
class CareTaker {
    // List to store mementos
    private List<Memento> mementoList = new ArrayList<>();

    // Method to add a memento to the list
    public void add(Memento state) {
        mementoList.add(state);
    }

    // Method to get a memento from the list by index
    public Memento get(int index) {
        return mementoList.get(index);
    }
}

// Demo class to test the Memento Pattern
public class MementoPattern {
    public static void main(String[] args) {
        // Creating an originator
        Originator originator = new Originator();

        // Creating a caretaker
        CareTaker careTaker = new CareTaker();

        // Setting and saving states
        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());

        // Changing the current state
        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());

        // Restoring states from mementos
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());

        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}
