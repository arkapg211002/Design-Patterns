// Iterator Pattern

import java.util.*;;

// Iterator interface defining the operations for iterating over a collection
interface Iterator {
    boolean hasNext();

    Object next();

    void remove();
}

// Container interface providing a way to get an iterator
interface Container {
    Iterator getIterator();
}

// Concrete implementation of the Container interface
class NameRepository implements Container {
    public String names[] = { "Arka", "Ram", "Shyam", "Jadu" };

    // Method to get an iterator for the names array
    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    // Private inner class implementing the Iterator interface
    private class NameIterator implements Iterator {
        int index;

        // Method to check if there is a next element
        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        // Method to get the next element
        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }

        // Method to remove the last element (optional implementation)
        @Override
        public void remove() {
            if (index > 0) {
                names = Arrays.copyOfRange(names, 0, index - 1);
                index--;
            }
        }
    }
}

// Demo class to test the Iterator Pattern
public class IteratorPattern {

    public static void main(String[] args) {
        // Creating an instance of NameRepository
        NameRepository namesRepository = new NameRepository();

        // Using an iterator to iterate over names
        for (Iterator iter = namesRepository.getIterator(); iter.hasNext();) {
            String name = (String) iter.next();
            System.out.println("Name: " + name);
        }

        // Removing the last name using the iterator's remove method
        Iterator iterator = namesRepository.getIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.remove();

        // Displaying the names after removal
        System.out.println("\nAfter removal:");
        for (Iterator iter = namesRepository.getIterator(); iter.hasNext();) {
            String name = (String) iter.next();
            System.out.println("Name: " + name);
        }
    }
}
