package task4;

import java.util.Scanner;

public class ShippingCapacity {

    // Check if we can ship all packages within 'days' using given 'capacity'
    public static boolean canShip(int[] weights, int days, int capacity) {
        int daysNeeded = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            // If single package exceeds capacity — impossible
            if (weight > capacity) return false;

            if (currentLoad + weight > capacity) {
                daysNeeded++;       // Start a new day
                currentLoad = 0;
            }
            currentLoad += weight;
        }

        return daysNeeded <= days;
    }

    public static int minCapacity(int[] weights, int days) {
        // Left boundary: max single weight (minimum possible capacity)
        // Right boundary: sum of all weights (ship everything in 1 day)
        int left = 0, right = 0;

        for (int w : weights) {
            left = Math.max(left, w);   // Must fit the heaviest package
            right += w;                  // Max = all packages in one day
        }

        // Binary search for the minimum valid capacity
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                right = mid;    // mid works → try smaller
            } else {
                left = mid + 1; // mid too small → try larger
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество пакетов: ");
        int n = scanner.nextInt();

        int[] weights = new int[n];
        System.out.print("Введите веса пакетов: ");
        for (int i = 0; i < n; i++)
            weights[i] = scanner.nextInt();

        System.out.print("Введите количество дней: ");
        int days = scanner.nextInt();

        int result = minCapacity(weights, days);
        System.out.println("Минимальная грузоподъёмность: " + result);

        // Show the shipping plan
        System.out.println("\nПлан доставки:");
        printShippingPlan(weights, days, result);

        scanner.close();
    }

    // Bonus: visualize the shipping plan
    public static void printShippingPlan(int[] weights, int days, int capacity) {
        int day = 1;
        int currentLoad = 0;
        StringBuilder dayPackages = new StringBuilder();

        for (int i = 0; i < weights.length; i++) {
            if (currentLoad + weights[i] > capacity) {
                System.out.println("День " + day + ": [" + dayPackages.toString().trim() + "] = " + currentLoad);
                day++;
                currentLoad = 0;
                dayPackages = new StringBuilder();
            }
            currentLoad += weights[i];
            dayPackages.append(weights[i]).append(" ");
        }
        System.out.println("День " + day + ": [" + dayPackages.toString().trim() + "] = " + currentLoad);
    }
}