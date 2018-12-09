package OOPPractice;

public class DeluxeBurger extends Hamburger {

    public DeluxeBurger() {
        super("Deluxe", "Sausage & Becon", "Cheese White", 12.99);
        super.addHamburgerAddition1("Chips", 3.99);
        super.addHamburgerAddition2("Drink", 2.99);
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("Additional ingredients not allowed");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("Additional ingredients not allowed");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("Additional ingredients not allowed");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("Additional ingredients not allowed");
    }
}
