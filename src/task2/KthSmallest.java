package task2;

import java.util.Scanner;

public class KthSmallest {

    // Sorts array in ascending order using bubble sort
    public static void bubbleSort(int[] numbers) {
        int length = numbers.length;

        for (int pass = 0; pass < length - 1; pass++) {
            for (int index = 0; index < length - pass - 1; index++) {
                if (numbers[index] > numbers[index + 1]) {
                    int temp = numbers[index];
                    numbers[index] = numbers[index + 1];
                    numbers[index + 1] = temp;
                }
            }
        }
    }

    // Returns the k-th smallest element from the sorted array
    public static int pickKthSmallest(int[] numbers, int position) {
        bubbleSort(numbers);
        return numbers[position - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];
        System.out.print("Enter the elements: ");
        for (int index = 0; index < size; index++)
            numbers[index] = scanner.nextInt();

        System.out.print("Enter k (which smallest to find): ");
        int position = scanner.nextInt();

        int result = pickKthSmallest(numbers, position);
        System.out.println(position + "-th smallest element is: " + result);

        scanner.close();
    }
}