package autoboxing;

import java.util.ArrayList;

public class Customer {

    private String name;

    private ArrayList<Double> transactions = new ArrayList<Double>();

    public Customer(String name, double transaction) {
        this.name = name;
        this.transactions.add(transaction);
    }

    public String getName() {
        return name;
    }

    public void addTransaction(double transaction) {
        transactions.add(transaction);
    }

    public void listTransactions() {
        int index = transactions.size();
        if (index > 0) {
            for (int i = 0; i < index; i++)
                System.out.println((i + 1) + ". " + transactions.get(i));
        } else {
            System.out.println("Customer: Customer list empty.");
        }
    }
}
