package autoboxing;

import java.util.ArrayList;
import java.util.Scanner;

public class Branch {

    public static Scanner scanner = new Scanner(System.in);
    private String name;
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public Branch(String name) {
        this.name = name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getName() {
        return name;
    }

    public boolean addNewCustomer() {
        System.out.println("Please input customers name: ");
        String name = scanner.nextLine();
        System.out.println("Please input value of initial transaction: ");
        double initialTransaction = scanner.nextDouble();
        scanner.nextLine();
        if (findCustomer(name) < 0) {
            customers.add(new Customer(name, initialTransaction));
            System.out.println("Branch: Added customer " + name + " with initial: " + initialTransaction + ".");
            return true;
        }
        System.out.println("Branch: customer " + name + "already exists.");
        return false;
    }

    public boolean addCustomerTransaction() {
        System.out.println("Please input customers name: ");
        String name = scanner.nextLine();
        System.out.println("Please input value of transaction: ");
        double transaction = scanner.nextDouble();
        int index = findCustomer(name);

        if (index >= 0) {
            customers.get(index).addTransaction(transaction);
            System.out.println("Branch: Transaction: " + transaction + " added for customer " + name + ".");
            return true;
        } else {
            System.out.println("Branch: customer " + name + "not found.");
            return false;
        }
    }

    public void listCustomers() {
        int index = customers.size();
        if (index > 0) {
            for (int i = 0; i < index; i++)
                System.out.println((i + 1) + ". " + customers.get(i).getName());
        } else {
            System.out.println("Branch: Customers list empty.");
        }
    }

    public int findCustomer(String name) {
        //return customer index in customers array or -1 if not found
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }



}
