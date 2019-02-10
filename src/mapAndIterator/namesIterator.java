package mapAndIterator;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class namesIterator {

    public static void main(String[] args) {

        Map<String, String>  names = new TreeMap<>();

        names.put("Kowalski", "Adam Kowalski - 24");
        names.put("Adamski", "Zbigniew Adamski - 28");
        names.put("Sikorska", "Beata Sikorska - 31");
        names.put("Debska", "Zuzanna Debska - 21");
        names.put("Mietczyński", "Karol Mietczynski - 23");

        Iterator<String> valueIterator = names.values().iterator();
        while (valueIterator.hasNext()) System.out.println(valueIterator.next());

        System.out.println("******************");
        //better:
        for (String s : names.values()) {
            System.out.println(s);
        }

        System.out.println("******************");
        //other:
        valueIterator = names.values().iterator();
        valueIterator.forEachRemaining(System.out::println);
    }
}
