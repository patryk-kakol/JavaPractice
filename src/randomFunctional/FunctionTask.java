package randomFunctional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionTask {

    public static void main(String[] args) {

        Random r = new Random();
        ArrayList<Integer> randomNumbers = new ArrayList<>();

        generate(randomNumbers, 10, () -> r.nextInt(100));
        consume(randomNumbers, x -> System.out.print(x + " "));
        System.out.println();
        filterList(randomNumbers, x -> x % 2 == 0);
        consume(randomNumbers, x -> System.out.print(x + " "));

    }

    private static <T> void generate(List<T> list, int toGenerate, Supplier<T> sup) {
        for (int i = 0; i < toGenerate; i++) {
            list.add(sup.get());
        }
    }

    private static <T> void consume(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    private static <T> void filterList(List<T> list, Predicate<T> predicate) {
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T tmp = iterator.next();
            if (predicate.test(tmp)) {
                iterator.remove();
            }
        }
    }

}
