package methodRefernce;

import java.util.Arrays;
import java.util.List;

public class SimpleStringComparator {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Abecki", "Babecki", "Ebecki", "Cebecki", "Debecki");
        names.sort(String::compareToIgnoreCase);
        names.forEach(System.out::println);
    }

}
