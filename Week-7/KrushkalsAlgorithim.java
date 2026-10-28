import java.util.*;

public class KrushkalsAlgorithim {
    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        public int compareTo(Edge other) {
            return Integer.compare(this.w, other.w);
        }
    }

    static class DSU {
        int[] parent;
        int[] rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;
            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pb] < rank[pa]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    static List<Edge> kruskal(int n, List<Edge> edges) {
        Collections.sort(edges);
        DSU dsu = new DSU(n);
        List<Edge> mst = new ArrayList<>();
        for (Edge e : edges) {
            if (dsu.union(e.u, e.v)) {
                mst.add(e);
                if (mst.size() == n - 1) break;
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        int n = 6;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(2, 3, 3));
        edges.add(new Edge(2, 5, 2));
        edges.add(new Edge(2, 4, 4));
        edges.add(new Edge(3, 4, 3));
        edges.add(new Edge(5, 4, 3));

        List<Edge> mst = kruskal(n, edges);
        int total = 0;
        System.out.println("MST edges:");
        for (Edge e : mst) {
            System.out.println(e.u + " - " + e.v + " : " + e.w);
            total += e.w;
        }
        System.out.println("Total weight: " + total);
    }
}