public class FlyodWarshallAlgo {
    static final int INF = 1_000_000_000;

    public static int[][] floydWarshall(int[][] w) {
        int n = w.length;
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = w[i][j];
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (d[i][k] == INF) continue;
                for (int j = 0; j < n; j++) {
                    if (d[k][j] == INF) continue;
                    int nd = d[i][k] + d[k][j];
                    if (nd < d[i][j]) d[i][j] = nd;
                }
            }
        }
        return d;
    }

    public static void printMatrix(int[][] d) {
        int n = d.length;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (d[i][j] >= INF / 2) sb.append("INF");
                else sb.append(d[i][j]);
                if (j + 1 < n) sb.append(" ");
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] w = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = (i == j) ? 0 : INF;
            }
        }
        w[0][1] = 5;
        w[0][3] = 10;
        w[1][2] = 3;
        w[2][3] = 1;

        int[][] d = floydWarshall(w);
        System.out.println("All-pairs shortest path distances:");
        printMatrix(d);
    }
}