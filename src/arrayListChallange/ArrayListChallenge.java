package arrayListChallange;

// Create a program that implements a simple mobile phone with the following capabilities.
// Able to store, modify, remove and query contact names.
// You will want to create a separate class for Contacts (name and phone number).
// Create a master class (MobilePhone (arrayListChallange.Contact list actually) that holds the ArrayList of Contacts
// The MobilePhone class has the functionality listed above.
// Add a menu of options that are available.
// Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
// and search/find contact.
// When adding or updating be sure to check if the contact already exists (use name)
// Be sure not to expose the inner workings of the Arraylist to MobilePhone
// e.g. no ints, no .get(i) etc
// MobilePhone should do everything with arrayListChallange.Contact objects only.

import java.util.Scanner;


public class ArrayListChallenge {

    private static Scanner scanner = new Scanner(System.in);
    private static ContactList contactList = new ContactList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;

        printInstructions();
        while(!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    addNewContact();
                    break;
                case 2:
                    modifyContact();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    findByName();
                    break;
                case 5:
                    printContactList();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }

    }

    public static void printInstructions() {
        System.out.println("\nPress: ");
        System.out.println("\t0 - to print choice options.");
        System.out.println("\t1 - to add new contact.");
        System.out.println("\t2 - to modify number of existing contact.");
        System.out.println("\t3 - to remove a contact.");
        System.out.println("\t4 - to find a contact by name.");
        System.out.println("\t5 - to print list of contacts.");
        System.out.println("\t6 - to exit.");
    }

    public static void addNewContact() {
        System.out.println("Please enter name of the contact: ");
        String name = scanner.nextLine();
        if(contactList.findContact(name) < 0 ) {
            System.out.println("Please enter number of the contact: ");
            int number = scanner.nextInt();
            contactList.addContact(name, number);
            System.out.println("Contact saved.");
        } else {
            System.out.println("Contact with such name already exists.");
        }
    }

    public static void modifyContact() {
        System.out.println("Enter the name of contact You want to modify: ");
        String name = scanner.nextLine();
        if(contactList.findContact(name) < 0 ) {
            System.out.println("Such contact does not exist.");
        } else {
            System.out.println("Enter new number for this contact: ");
            int number = scanner.nextInt();
            contactList.changeNumber(name, number);
        }
    }

    public static void removeContact() {
        System.out.println("Please enter the name of the contact: ");
        String name = scanner.nextLine();
        contactList.deleteContact(name);
    }

    public static void printContactList() {
        contactList.printList();
    }

    public static void findByName() {
        System.out.println("Please enter the name of the contact");
        String name = scanner.nextLine();
        System.out.println(contactList.findAndPrint(name));
    }

}
