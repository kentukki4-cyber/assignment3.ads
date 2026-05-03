package task1;

import java.util.Scanner;

public class AnagramChecker {

    public static boolean isAnagram(String s1, String s2) {
        s1 = s1.toLowerCase().replaceAll("\\s+", "");
        s2 = s2.toLowerCase().replaceAll("\\s+", "");

        if (s1.length() != s2.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int c : count)
            if (c != 0) return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(" ");
            String s1 = scanner.nextLine().trim();

            if (s1.equalsIgnoreCase("exit")) {
                System.out.println(" ");
                break;
            }

            System.out.print(" ");
            String s2 = scanner.nextLine().trim();

            if (isAnagram(s1, s2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}