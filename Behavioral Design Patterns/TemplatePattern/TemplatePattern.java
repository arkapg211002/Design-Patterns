// Abstract class defining the template method
abstract class Game {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    // Template method
    public final void play() {
        // Initialize the game
        initialize();

        // Start game
        startPlay();

        // End game
        endPlay();
    }
}

// Concrete class implementing the Cricket game
class Cricket extends Game {
    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}

// Concrete class implementing the Football game
class Football extends Game {
    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}

// Demo class to test the Template Method Pattern
public class TemplatePattern {
    public static void main(String[] args) {
        // Create and play Cricket game
        Game cricketGame = new Cricket();
        cricketGame.play();

        System.out.println();

        // Create and play Football game
        Game footballGame = new Football();
        footballGame.play();
    }
}
