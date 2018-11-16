import java.util.Scanner;

public class MinAndMaxInput {
    public static void main(String[] args) {

        int max = 0;
        int min = 0;
        int a;
        boolean start = true;
        Scanner reader = new Scanner(System.in);

        while ( true ) {
            System.out.print("Enter number: ");

            if (!reader.hasNextInt()) {
                break;
            } else {
                if ( start ) {
                    a = reader.nextInt();
                    min = a;
                    max = a;
                    start = !start;
                } else {
                    a = reader.nextInt();
                    if (a > max) max = a;
                    if (a < min) min = a;
                }
            }
            //reader.nextLine();
        }
        reader.close();
        System.out.println("Max = " + max + " || Min = " + min);
    }
}
