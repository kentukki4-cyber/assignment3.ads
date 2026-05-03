package task3;

import java.util.Arrays;
import java.util.Scanner;

public class Median {

    public static double findMedian(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        if (n % 2 == 1) {
            // Odd: return middle element
            return arr[n / 2];
        } else {
            // Even: return average of two middle elements
            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.print("Введите элементы: ");
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        System.out.println("Медиана: " + findMedian(arr));
        scanner.close();
    }
}