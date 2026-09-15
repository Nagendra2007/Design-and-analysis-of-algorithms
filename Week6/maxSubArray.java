import java.util.Scanner;
 
public class MaxSubArrayDC {
 
    static int finalLow, finalHigh;
 
    static int maxCrossingSum(int[] arr, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = mid;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = mid + 1;
        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        finalLow = maxLeft;
        finalHigh = maxRight;
        return leftSum + rightSum;
    }
 
    static int maxSubArraySum(int[] arr, int low, int high) {
        if (low == high) {
            finalLow = low;
            finalHigh = high;
            return arr[low];
        }
        int mid = (low + high) / 2;
        int leftLow, leftHigh, rightLow, rightHigh;
 
        int leftSum = maxSubArraySum(arr, low, mid);
        leftLow = finalLow; leftHigh = finalHigh;
 
        int rightSum = maxSubArraySum(arr, mid + 1, high);
        rightLow = finalLow; rightHigh = finalHigh;
 
        int crossSum = maxCrossingSum(arr, low, mid, high);
        int crossLow = finalLow, crossHigh = finalHigh;
 
        if (leftSum >= rightSum && leftSum >= crossSum) {
            finalLow = leftLow; finalHigh = leftHigh;
            return leftSum;
        } else if (rightSum >= leftSum && rightSum >= crossSum) {
            finalLow = rightLow; finalHigh = rightHigh;
            return rightSum;
        } else {
            finalLow = crossLow; finalHigh = crossHigh;
            return crossSum;
        }
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
        int maxSum = maxSubArraySum(arr, 0, n - 1);
        System.out.println("Maximum subarray sum: " + maxSum);
        System.out.print("Subarray: ");
        for (int i = finalLow; i <= finalHigh; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}
