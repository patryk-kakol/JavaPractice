package autoboxing;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private ArrayList<Branch> branches = new ArrayList<Branch>();
    public static Scanner scanner = new Scanner(System.in);

    public void bankMenu() {
        System.out.println("Welcome to the bank!");
        int choice = 0;
        while (choice != 9) {
            System.out.println("\nEnter action: (0 to show available actions)");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printBankOptions();
                    break;

                case 1:
                    listBranches();
                    break;

                case 2:
                    listBranchCustomers();
                    break;

                case 3:
                    listBranchCustomerTransactions();
                    break;

                case 4:
                    addBranch();
                    break;

                case 5:
                    addCustomerToBranch();
                    break;

                case 6:
                    addBranchCustomerTransaction();
                    break;
            }
        }
    }

    private void printBankOptions() {
        System.out.println("0 - To show this menu.");
        System.out.println("1 - List branches.");
        System.out.println("2 - List customers of particular branch.");
        System.out.println("3 - List transaction of particular customer from particular branch.");
        System.out.println("4 - Add new branch.");
        System.out.println("5 - Add new customer to existing branch.");
        System.out.println("6 - Add transaction to customer in existing branch.");
        System.out.println("9 - To exit.");
    }

    private void listBranches() {
        int index = branches.size();
        if (index > 0) {
            for (int i = 0; i < index; i++)
                System.out.println((i + 1) + ". " + branches.get(i).getName());
        } else {
            System.out.println("Bank: Branch list empty.");
        }
    }

    private void listBranchCustomers() {
        System.out.println("Please input branch name: ");
        String branchName = scanner.nextLine();
        int branchIndex = findBranch(branchName);
        if (branchIndex >= 0) {
            branches.get(branchIndex).listCustomers();
        } else {
            System.out.println("Bank: Branch does not exist.");
        }
    }

    private void listBranchCustomerTransactions() {
        System.out.println("Please input branch name: ");
        String branchName = scanner.nextLine();
        int branchIndex = findBranch(branchName);
        if (branchIndex >= 0) {
            System.out.println("Please input customer name: ");
            String customerName = scanner.nextLine();
            int customerIndex = branches.get(branchIndex).findCustomer(customerName);
            if (customerIndex >= 0) {
                branches.get(branchIndex).getCustomers().get(customerIndex).listTransactions();
            } else {
                System.out.println("Bank: Customer does not exist in this branch.");
            }
        } else {
            System.out.println("Bank: Branch does not exist.");
        }
    }

    private boolean addBranch() {
        System.out.println("Please input branch name: ");
        String name = scanner.nextLine();
        if (findBranch(name) < 0) {
            branches.add(new Branch(name));
            System.out.println("Bank: Branch " + name + " created.");
            return true;
        } else {
            System.out.println("Bank: Branch " + name + " already exists.");
            return false;
        }
    }

    private boolean addCustomerToBranch() {
        System.out.println("Please input branch name: ");
        String branchName = scanner.nextLine();
        int branchIndex = findBranch(branchName);

        if (branchIndex >= 0) {
            System.out.println("Bank: Branch " + branchName + " exists.");
            if (branches.get(branchIndex).addNewCustomer()) {
                return true;
            }
        }
        System.out.println("Bank: Branch " + branchName + " does not exist.");
        return false;

    }

    private boolean addBranchCustomerTransaction() {
        System.out.println("Please input branch name: ");
        String branchName = scanner.nextLine();
        int branchIndex = findBranch(branchName);

        if (branchIndex >= 0) {
            System.out.println("Bank: Branch " + branchName + " exists.");
            if (branches.get(branchIndex).addCustomerTransaction()) {
                return true;
            }
        }
        System.out.println("Bank: Branch " + branchName + " does not exist.");
        return false;
    }

    private int findBranch(String name) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
