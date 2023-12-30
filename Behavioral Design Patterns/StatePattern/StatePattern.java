// Interface representing different states
interface State {
    void doAction(Context context);
}

// Concrete implementation of the StartState
class StartState implements State {
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    public String toString() {
        return "Start State";
    }
}

// Concrete implementation of the StopState
class StopState implements State {
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString() {
        return "Stop State";
    }
}

// Context class that maintains the current state
class Context {
    private State state;

    public Context() {
        state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}

// Demo class to test the State Pattern
public class StatePattern {
    public static void main(String[] args) {
        // Creating a context
        Context context = new Context();

        // Creating and executing the StartState
        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        // Creating and executing the StopState
        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }
}
