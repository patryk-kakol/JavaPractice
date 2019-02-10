package comparisons;

import java.util.Arrays;
import java.util.Comparator;

public class compareTests {

    public static void main(String[] args) {

        Product[] products = new Product[7];
        products[0] = new Product("Amino", "Zupa pomidorowa", "Zupy");
        products[1] = new Product("Amino", "Zupa ogórkowa", "Zupy");
        products[2] = new Product("WINIARY", "Zupa pomidorowa", "Zupy");
        products[3] = new Product("WINIARY", "Zupa pomidorowa", "Zupy błyskawiczne");
        products[4] = new Product("WINIARY", "Rosół", "Zupy");
        products[5] = new Product("Knorr", "Placki ziemniaczane", "Dania obiadowe");
        products[6] = new Product("Knorr", "Racuchy", "Dania obiadowe");

        System.out.println("Unsorted: ");
        for (Product p : products) {
            System.out.println(p);
        }

        Arrays.sort(products);
        System.out.println("Sorted: ");
        for (Product p : products) {
            System.out.println(p);
        }

        Arrays.sort(products, new Product.ProductNameComparator());
        System.out.println("Sorted by name: ");
        for (Product p : products) {
            System.out.println(p);
        }


        System.out.println("******************");
        Integer[] intArray = {3, 5, 7, 2, 7, 9, 3, 10, 12, 1, 32, 21, 19, 8, 15, 4};
        Arrays.sort(intArray, new Comparator<Integer>() {

            public int compare(Integer i1, Integer i2) {
                return -(i1.compareTo(i2));
            }
        });
        System.out.println("Integers decreasing order: ");
        for (Integer i : intArray) {
            System.out.print(i + " ");
        }

        Arrays.sort(intArray);
        System.out.println("\nIntegers increasing order: ");
        for (Integer i : intArray) {
            System.out.print(i + " ");
        }
    }
}
