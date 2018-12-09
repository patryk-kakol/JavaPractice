package OOPPractice;


public class OOPPractice {
    public static void main(String[] args) {

        Hamburger basic = new Hamburger("Basic", "Sousage", "White", 3.59);
        itemize(basic);
        basic.addHamburgerAddition1("Tomato", 0.29);
        basic.addHamburgerAddition2("Salad", 0.29);
        basic.addHamburgerAddition3("Chilli", 0.39);
        itemize(basic);

        HealthyBurger healthy = new HealthyBurger("Soya Steak", 5.99);
        healthy.addHamburgerAddition1("Tomato", 0.29);
        healthy.addHamburgerAddition2("Salad", 0.29);
        healthy.addHamburgerAddition3("Oats", 0.39);
        healthy.addHamburgerAddition4("Olive oil", 0.29);
        healthy.addHealthyAddition1("Cheese", 0.69);
        healthy.addHealthyAddition2("Corn", 0.29);
        itemize(healthy);

        DeluxeBurger deluxe = new DeluxeBurger();
        deluxe.addHamburgerAddition1("Chilli", 0.39);
        itemize(deluxe);
    }

    public static void itemize(Hamburger burger) {
        double price = burger.itemizeHamburger();
        System.out.println("Total price is " + price + "\n =========================");
    }
}
