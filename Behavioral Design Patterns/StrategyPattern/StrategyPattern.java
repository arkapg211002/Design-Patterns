
// Strategy Pattern
import java.util.*;

// Interface representing the strategy
interface Strategy {
    int doOperation(int num1, int num2);
}

// Concrete strategy for addition
class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

// Concrete strategy for subtraction
class OperationSubtract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

// Concrete strategy for multiplication
class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

// Context class that uses a strategy
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}

// Demo class to test the Strategy Pattern
public class StrategyPattern {
    public static void main(String[] args) {
        // Creating a context with the addition strategy
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        // Creating a context with the subtraction strategy
        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        // Creating a context with the multiplication strategy
        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
