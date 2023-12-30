/*
 *  Proxy Pattern
 */

// Interface representing an image
interface Image {
    void display();
}

// RealImage class implementing the Image interface
class RealImage implements Image {

    private String fileName;

    // Constructor with filename parameter
    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}

// ProxyImage class implementing the Image interface
class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    // Constructor with filename parameter
    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

// Demo class to test the Proxy Pattern
public class ProxyPattern {

    public static void main(String[] args) {
        // Creating an instance of ProxyImage
        Image image = new ProxyImage("test_10mb.jpg");

        // Image will be loaded from disk
        image.display();
        System.out.println("");

        // Image will not be loaded from disk
        image.display();
    }
}
