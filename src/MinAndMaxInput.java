import java.util.Scanner;

public class MinAndMaxInput {
    public static void main(String[] args) {

        int max = 0;
        int min = 0;
        Scanner reader = new Scanner(System.in);

        while ( true ) {
            System.out.print("Enter number: ");

            if (!reader.hasNextInt()) {
                break;
            } else {
                if (reader.nextInt() > max) max = reader.nextInt();
                if (reader.nextInt() < min) min = reader.nextInt();

            }
            //reader.nextLine();
        }
        reader.close();
        System.out.println("Max = " + max + " || Min = " + min);
    }
}
