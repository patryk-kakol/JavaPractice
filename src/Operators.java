
// 1. Create a double variable with the value 20
// 2. Create a second variable of type double with the value 80
// 3. Add both numbers up and multiply by 25
// 4. Use the remainder operator to figure out the remainder from the sum of #3 divided by 40
// 5. Write an "if" statement that displays a message "Total was over the limit"
//    if the remaining total (#4) is equal to 20 or less.


public class Operators {
    public static void main(String[] args) {
        double myVar1 = 20d;
        double myVar2 = 80d;

        double result = (myVar1 + myVar2) * 25;
        double total = result % 40;
        System.out.println("var 1: " + myVar1);
        System.out.println("var 2: " + myVar2);
        System.out.println("result: " + result);
        System.out.println("total: " + total);

        if (total <= 20) {
            System.out.println("Total was over the limit");
        }

    }
}
