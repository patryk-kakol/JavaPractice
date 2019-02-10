package comparisons;

import java.util.Comparator;

public class Product implements Comparable<Product> {

    private String category;
    private String producer;
    private String name;

    public Product(String producer, String name, String category) {
        this.category = category;
        this.producer = producer;
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category='" + category + '\'' +
                ", producer='" + producer + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product p) {
        int categoryCompare = this.category.compareTo(p.getCategory());
        if (categoryCompare != 0) {
            return categoryCompare;
        }
        int producerCompare = this.producer.compareTo(p.getProducer());
        if (producerCompare != 0) {
            return producerCompare;
        }
        return this.name.compareTo(p.getName());
    }

    public static class ProductNameComparator implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }

}
