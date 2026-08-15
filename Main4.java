package week2.kthSmallestElement;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first term (a): ");
        double a = sc.nextDouble();

        System.out.print("Enter common ratio (r): ");
        double r = sc.nextDouble();

        System.out.print("Enter number of terms (n): ");
        int n = sc.nextInt();

        double sum = 0;
        double term = a;

        for (int i = 0; i < n; i++) {
            sum += term;
            term *= r;
        }

        System.out.println("Sum of GP series: " + sum);

        sc.close();
    }
}
