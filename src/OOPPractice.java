class Hamburger {
    private String name;
    private String meat;
    private String breadRollType;
    private double price;

    private String addition1Name;
    private double addition1Price;
    private String addition2Name;
    private double addition2Price;
    private String addition3Name;
    private double addition3Price;
    private String addition4Name;
    private double addition4Price;

    public Hamburger(String name, String meat, String breadRollType, double price) {
        this.name = name;
        this.meat = meat;
        this.breadRollType = breadRollType;
        this.price = price;
    }

    public void addHamburgerAddition1(String name, double price) {
        this.addition1Name = name;
        this.addition1Price = price;
    }
    public void addHamburgerAddition2(String name, double price) {
        this.addition2Name = name;
        this.addition2Price = price;
    }
    public void addHamburgerAddition3(String name, double price) {
        this.addition3Name = name;
        this.addition3Price = price;
    }
    public void addHamburgerAddition4(String name, double price) {
        this.addition4Name = name;
        this.addition4Price = price;
    }

    public double itemizeHamburger() {
        double hamburgerPrice = this.price;
        System.out.println("Hamburger: " + this.name + "\n + meat: " + this.meat + "\n + bread: " + this.breadRollType
            + "\nPrice is " + hamburgerPrice);
        if(addition1Name != null) {
            hamburgerPrice += this.addition1Price;
            System.out.println(" + Adding " + this.addition1Name + " for an extra " + this.addition1Price);
        }
        if(addition2Name != null) {
            hamburgerPrice += this.addition2Price;
            System.out.println(" + Adding " + this.addition2Name + " for an extra " + this.addition2Price);
        }
        if(addition3Name != null) {
            hamburgerPrice += this.addition3Price;
            System.out.println(" + Adding " + this.addition3Name + " for an extra " + this.addition3Price);
        }
        if(addition4Name != null) {
            hamburgerPrice += this.addition4Price;
            System.out.println(" + Adding " + this.addition4Name + " for an extra " + this.addition4Price);
        }
        return hamburgerPrice;
    }
}

class HealthyBurger extends Hamburger {
    private String healthyExtra1Name;
    private double healthyExtra1Price;
    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        super("Healthy", meat, "Brown Rye", price);
    }

    public void addHealthyAddition1(String name, double price) {
        this.healthyExtra1Name = name;
        this.healthyExtra1Price = price;
    }

    public void addHealthyAddition2(String name, double price) {
        this.healthyExtra2Name = name;
        this.healthyExtra2Price = price;
    }

    @Override
    public double itemizeHamburger() {
        double hamburgerPrice = super.itemizeHamburger();
        if(healthyExtra1Name != null) {
            hamburgerPrice += this.healthyExtra1Price;
            System.out.println(" + Adding " + this.healthyExtra1Name + " for an extra " + this.healthyExtra1Price);
        }
        if(healthyExtra2Name != null) {
            hamburgerPrice += this.healthyExtra2Price;
            System.out.println(" + Adding " + this.healthyExtra2Name + " for an extra " + this.healthyExtra2Price);
        }
        return hamburgerPrice;
    }

}

class DeluxeBurger extends Hamburger {

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




public class OOPPractice {
    public static void main(String[] args) {

        Hamburger basic = new Hamburger("Basic", "Sousage", "White", 3.59);
        double basicPrice = basic.itemizeHamburger();
        basic.addHamburgerAddition1("Tomato", 0.29);
        basic.addHamburgerAddition2("Salad", 0.29);
        basic.addHamburgerAddition3("Chilli", 0.39);
        basicPrice = basic.itemizeHamburger();
        System.out.println("Total price is " + basicPrice + "\n =========================");

        HealthyBurger healthy = new HealthyBurger("Soya Steak", 5.99);
        healthy.addHamburgerAddition1("Tomato", 0.29);
        healthy.addHamburgerAddition2("Salad", 0.29);
        healthy.addHamburgerAddition3("Oats", 0.39);
        healthy.addHamburgerAddition4("Olive oil", 0.29);
        healthy.addHealthyAddition1("Cheese", 0.69);
        healthy.addHealthyAddition2("Corn", 0.29);
        double healthyPrice = healthy.itemizeHamburger();
        System.out.println("Total price is " + healthyPrice + "\n =========================");


        DeluxeBurger deluxe = new DeluxeBurger();
        deluxe.addHamburgerAddition1("Chilli", 0.39);
        double deluxePrice = deluxe.itemizeHamburger();
        System.out.println("Total price is " + deluxePrice + "\n =========================");
    }
}
