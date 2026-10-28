import java.util.Arrays;

public class PrimsAlgo {
    static int[] primMST(int[][] graph) {
        int n = graph.length;
        int[] parent = new int[n];
        int[] key = new int[n];
        boolean[] inMST = new boolean[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < n - 1; count++) {
            int u = -1;
            int min = Integer.MAX_VALUE;
            for (int v = 0; v < n; v++) {
                if (!inMST[v] && key[v] < min) {
                    min = key[v];
                    u = v;
                }
            }
            if (u == -1) break;
            inMST[u] = true;
            for (int v = 0; v < n; v++) {
                int w = graph[u][v];
                if (w > 0 && !inMST[v] && w < key[v]) {
                    parent[v] = u;
                    key[v] = w;
                }
            }
        }
        return parent;
    }

    static void printMST(int[] parent, int[][] graph) {
        int total = 0;
        System.out.println("Edges in MST:");
        for (int v = 1; v < parent.length; v++) {
            int u = parent[v];
            int w = graph[v][u];
            System.out.println(u + " - " + v + " : " + w);
            total += w;
        }
        System.out.println("Total weight: " + total);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };
        int[] parent = primMST(graph);
        printMST(parent, graph);
    }
}