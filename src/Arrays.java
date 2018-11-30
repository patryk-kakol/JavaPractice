// Challenge 1
// Create a program using arrays that sorts a list of integers in descending order.
// Descending order is highest value to lowest.
// In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
// ultimately have an array with 106,81,26, 15, 5 in it.
// Set up the program so that the numbers to sort are read in from the keyboard.
// Implement the following methods - getIntegers, printArray, and sortIntegers
// getIntegers returns an array of entered integers from keyboard
// printArray prints out the contents of the array
// and sortIntegers should sort the array and return a new array containing the sorted numbers
// you will have to figure out how to copy the array elements from the passed array into a new
// array and sort them and return the new sorted array.

// Challenge 2
// Create function to find min element of the array.

// Challenge 3
// Create function to reverse an array.

import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        int[] array = getIntegers();
        System.out.println("================ \nYour array:");
        printArray(array);
        System.out.println("================ \nReversed array:");
        printArray(reverseArray(array));
        System.out.println("================ \nMin element of this array:");
        System.out.println(findMin(array));
        System.out.println("================ \nSorted array:");
        printArray(sortIntegers(array));


    }

    public static int[] getIntegers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many integers do You want to input? ");
        int length = scanner.nextInt();
        int[] intArray = new int[length];

        System.out.println("Enter integers: \r");
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = scanner.nextInt();
        }

        return intArray;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ": " + array[i]);
        }
    }
//Insertion sort
    public static int[] sortIntegers(int[] array) {
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] < sortedArray[i - 1]) {
                sortedArray[i] = array[i];
            } else {

                for (int j = 0; j < sortedArray.length; j++) {
                    if (array[i] > sortedArray[j]) {
                        for (int k = sortedArray.length - 1; k > j; k--) {
                            sortedArray[k] = sortedArray[k - 1];
                        }
                        sortedArray[j] = array[i];
                        break;
                    }
                }
            }
        }
        return sortedArray;
    }

    public static int findMin(int[] array) {
        int minElement = array[0];

        for (int i = 0; i < array.length; i++) {
            if (minElement > array[i]) minElement = array[i];
        }
        return minElement;
    }

    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }
}
