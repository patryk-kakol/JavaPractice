import java.util.Scanner;

public class ReadingInput {
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        Scanner reader = new Scanner(System.in);

        while ( i <= 10 ) {
            System.out.println("Enter number #" + i + ":");

            if (!reader.hasNextInt()) {
                System.out.println("Invalid Number");
            } else {
                sum += reader.nextInt();
                i += 1;
            }
            reader.nextLine();
        }
        reader.close();
        System.out.println("Sum = " + sum);
    }
}
