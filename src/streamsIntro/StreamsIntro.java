package streamsIntro;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsIntro {


    public static void main(String[] args) {
        // one way
        List<Integer> list =  Stream
                .iterate(0, x -> x + 1)
                .filter(x -> x > 100 && x < 1000 && x % 5 == 0)
                .limit(10)
                .map(x -> x * 3)
                .peek(System.out::println)
                .collect(Collectors.toList());
        // or direct
        System.out.println("=================");
        Stream.iterate(0, x -> x+1)
                .filter(x -> x>100 && x<1000 && x%5==0)
                .limit(10)
                .map(x -> x*3)
                .forEach(System.out::println);

    }

}
