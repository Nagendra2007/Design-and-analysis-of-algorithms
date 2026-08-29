import java.util.HashSet;
import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();
        HashSet<Integer> seen = new HashSet<>();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            int complement = target - arr[i];
            if (seen.contains(complement)) {
                System.out.println("Pair found: " + complement
                    + " + " + arr[i] + " = " + target);
                found = true;
                break;
            }
            seen.add(arr[i]);
        }
        if (!found) {
            System.out.println("No pair found with sum " + target);
        }
        sc.close();
    }
}
