
/*
 *  Command Pattern
 */
import java.util.*;
import java.lang.*;
import java.io.*;

interface Order {
    public void execute();
}

class Stock {
    private String name;
    private int quantity;

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void buy() {
        System.out.println("Buy Stock : " + name);
        System.out.println("Price : " + quantity);
    }

    public void sell() {
        System.out.println("Sell Stock : " + name);
        System.out.println("Price : " + quantity);
    }

}

class BuyStock implements Order {
    Stock abc;

    public BuyStock(Stock abc) {
        this.abc = abc;
    }

    @Override
    public void execute() {
        abc.buy();
    }
}

class SellStock implements Order {
    Stock abc;

    public SellStock(Stock abc) {
        this.abc = abc;
    }

    @Override
    public void execute() {
        abc.sell();
    }
}

class Broker {
    List<Order> orders = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orders.add(order);
    }

    public void giveOrder() {
        for (Order o : orders) {
            o.execute();
        }
        orders.clear();
    }
}

public class CommandPattern {
    public static void main(String args[]) throws Exception {
        Stock s = new Stock("ABC", 10);
        BuyStock s1 = new BuyStock(s);
        SellStock s2 = new SellStock(s);
        Broker s3 = new Broker();
        s3.takeOrder(s1);
        s3.takeOrder(s2);
        s3.giveOrder();
    }
}
