import java.util.Scanner;
 
public class MatrixChainMultiplication {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();
 
        int[] p = new int[n + 1];
        System.out.println("Enter " + (n + 1) + " dimensions:");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }
 
        int[][] m = new int[n + 1][n + 1];
 
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                    }
                }
            }
        }
 
        System.out.println("Minimum number of multiplications = " + m[1][n]);
        sc.close();
    }
}
