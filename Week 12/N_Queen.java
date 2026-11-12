import java.util.Scanner;

public class NQueens {

    static int n;
    static int[] pos;
    static int count = 0;

    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (pos[i] == col || Math.abs(pos[i] - col) == row - i) {
                return false;
            }
        }
        return true;
    }

    static void solve(int row) {
        if (row == n) {
            count++;
            System.out.println("Solution " + count + ":");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(pos[i] == j ? "Q " : ". ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                pos[row] = col;
                solve(row + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        n = sc.nextInt();
        pos = new int[n];
        solve(0);
        System.out.println("Total solutions = " + count);
        sc.close();
    }
}
