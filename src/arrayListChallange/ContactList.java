package arrayListChallange;

import java.util.ArrayList;

class ContactList {
    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    public void addContact(String name, int number) {
        contactList.add(new Contact(name, number));
    }

    public void printList() {
        System.out.println("You have " + contactList.size() + " contacts.");
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println((i+1) + ". " + contactList.get(i));
        }
    }

    public int findContact(String name) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getName().equals(name)) return i;
        }
        return -1;
    }

    public String findAndPrint(String name) {
        int position = findContact(name);
        if(position >= 0) {
            return contactList.get(position).toString();
        } else
            return "There is no such contact";

    }

    public void changeNumber (String name, int newNumber) {
        int position = findContact(name);
        if(position >= 0) contactList.set(position, new Contact(name, newNumber));
    }

    public void deleteContact(String name) {
        int position = findContact(name);
        if(position >= 0) {
            contactList.remove(position);
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Such contact does not exist.");
        }
    }

}
