import java.util.*;
import java.io.*;
import java.lang.*;

// Abstract Class
abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    public int level;
    public AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String msg) {
        if (this.level <= level)
            write(msg);
        if (nextLogger != null)
            nextLogger.logMessage(level, msg);
    }

    abstract void write(String msg);
}

// Concrete Classes
class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    public void write(String msg) {
        System.out.println("Inside ConsoleLogger : " + msg);
    }
}

class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    public void write(String msg) {
        System.out.println("Inside ErrorLogger : " + msg);
    }
}

class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    public void write(String msg) {
        System.out.println("Inside FileLogger : " + msg);
    }
}

public class ChainOfResponsibility {
    public static AbstractLogger getChain() {
        AbstractLogger error = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger file = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger console = new ConsoleLogger(AbstractLogger.INFO);
        error.setNextLogger(file);
        file.setNextLogger(console);

        return error;
    }

    public static void main(String args[]) throws Exception {
        AbstractLogger chain = getChain();
        System.out.println("--------------------------------");
        chain.logMessage(1, "This is information");
        System.out.println("--------------------------------");
        chain.logMessage(2, "This is debug information");
        System.out.println("--------------------------------");
        chain.logMessage(3, "This is error information");
    }
}
