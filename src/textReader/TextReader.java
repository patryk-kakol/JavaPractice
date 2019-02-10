package textReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextReader {

    public static void main(String[] args) {

        final String FILE_PATH = "C:\\Users\\patry\\OneDrive\\Pulpit\\dev\\src\\textReader\\text.txt";
        List<String> words = new ArrayList<>();

// ONE WAY:
/*        String tmp;
        try (var reader = new BufferedReader(new FileReader(FILE_PATH))) {
            while ((tmp = reader.readLine()) != null ) {
                words.addAll(Arrays.asList(tmp.split(" ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        words = words.stream()
                .map(x -> x.replaceAll("\\.", "")
                        .replaceAll(",", ""))
                .collect(Collectors.toList());
*/
// OR ANOTHER:
        try (var reader = new BufferedReader(new FileReader(FILE_PATH))) {
            words = reader.lines()
                    .map(line -> line.split(" "))
                    .flatMap(Arrays::stream)
                    .map(s -> s.replaceAll(",", "")
                            .replaceAll("\\.", ""))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
//////
        long leadingS = words.stream()
                .filter(x -> x.startsWith("s"))
                .count();

        long fiveCharsLong = words.stream()
                .filter(x -> x.length() == 5)
                .count();

        System.out.println("Starting with s strings counted: " + leadingS);
        System.out.println("Five chars longs strings counted: " + fiveCharsLong);
    }
}
