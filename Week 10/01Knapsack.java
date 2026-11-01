import java.util.*;
public class Knapsack01 {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter number of items: ");
int n = sc.nextInt();
int[] w = new int[n + 1], v = new int[n + 1];
System.out.println("Enter weight and value of each item:");
for (int i = 1; i <= n; i++) {
System.out.print("Item " + i + ": ");
w[i] = sc.nextInt();
v[i] = sc.nextInt();
}
System.out.print("Enter knapsack capacity: ");
int W = sc.nextInt();
int[][] dp = new int[n + 1][W + 1];
for (int i = 1; i <= n; i++) {
for (int j = 0; j <= W; j++) {
int skip = dp[i - 1][j];
int take = (w[i] <= j) ? v[i] + dp[i - 1][j - w[i]] : 0;
dp[i][j] = Math.max(skip, take);
}
}
System.out.println("\nMaximum value in knapsack = " + dp[n][W]);
System.out.print("Items selected:");
for (int i = n, j = W; i > 0; i--) {
if (dp[i][j] != dp[i - 1][j]) {
System.out.print(" " + i);
j -= w[i];
}
}
System.out.println();
}
}
