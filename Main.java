package week2.kthSmallestElement;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Solution sol = new Solution();
        int result = sol.findKthSmallest(arr, k);

        System.out.println("The " + k + "th smallest element is: " + result);

        sc.close();
    }
}

class Solution {
    public int findKthSmallest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    private int quickSelect(int[] arr, int left, int right, int targetIdx) {
        while (left < right) {
            int pivotIdx = partition(arr, left, right);
            if (pivotIdx == targetIdx) {
                return arr[pivotIdx];
            } else if (pivotIdx < targetIdx) {
                left = pivotIdx + 1;
            } else {
                right = pivotIdx - 1;
            }
        }
        return arr[left];
    }

    private int partition(int[] arr, int left, int right) {
        int randomIdx = left + new Random().nextInt(right - left + 1);
        swap(arr, randomIdx, right);

        int pivot = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}