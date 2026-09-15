import java.util.Scanner;
 
public class MaxMinDC {
 
    static int max, min;
 
    public static void findMaxMin(int[] arr, int low, int high) {
        if (low == high) {
            if (arr[low] > max) max = arr[low];
            if (arr[low] < min) min = arr[low];
            return;
        }
        if (high - low == 1) {
            if (arr[low] > arr[high]) {
                if (arr[low] > max) max = arr[low];
                if (arr[high] < min) min = arr[high];
            } else {
                if (arr[high] > max) max = arr[high];
                if (arr[low] < min) min = arr[low];
            }
            return;
        }
        int mid = (low + high) / 2;
        findMaxMin(arr, low, mid);
        findMaxMin(arr, mid + 1, high);
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        max = arr[0];
        min = arr[0];
        findMaxMin(arr, 0, n - 1);
        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);
        sc.close();
    }
}
