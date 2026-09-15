import java.util.Scanner;
 
public class Strassesns {
 
    public static int[][] multiply(int[][] A, int[][] B) {
        int a = A[0][0], b = A[0][1], c = A[1][0], d = A[1][1];
        int e = B[0][0], f = B[0][1], g = B[1][0], h = B[1][1];
 
        int p1 = a * (f - h);
        int p2 = (a + b) * h;
        int p3 = (c + d) * e;
        int p4 = d * (g - e);
        int p5 = (a + d) * (e + h);
        int p6 = (b - d) * (g + h);
        int p7 = (a - c) * (e + f);
 
        int c11 = p5 + p4 - p2 + p6;
        int c12 = p1 + p2;
        int c21 = p3 + p4;
        int c22 = p1 + p5 - p3 - p7;
 
        return new int[][]{{c11, c12}, {c21, c22}};
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] A = new int[2][2];
        int[][] B = new int[2][2];
 
        System.out.println("Enter elements of 2x2 matrix A:");
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                A[i][j] = sc.nextInt();
 
        System.out.println("Enter elements of 2x2 matrix B:");
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                B[i][j] = sc.nextInt();
 
        int[][] C = multiply(A, B);
 
        System.out.println("Resultant matrix (A x B):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
