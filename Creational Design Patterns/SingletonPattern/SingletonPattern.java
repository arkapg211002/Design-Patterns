/*
 *  Singleton Pattern
 */
public class SingletonPattern {

    // create an object of SingleObject
    private static SingletonPattern instance = new SingletonPattern();

    // make the constructor private so that this class cannot be
    // instantiated
    private SingletonPattern() {
    }

    // Get the only object available
    public static SingletonPattern getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {

        // illegal construct
        // Compile Time Error: The constructor SingletonPattern() is not visible
        // SingletonPattern object = new SingletonPattern();

        // Get the only object available
        SingletonPattern object = SingletonPattern.getInstance();

        // show the message
        object.showMessage();
    }
}
