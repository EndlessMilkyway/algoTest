package baekjoon.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1197 {
    private static int V;
    private static int E;
    private static int[] parent;
    private static Queue<Edge> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        init();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            queue.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
        System.out.println(kruskal());
    }

    private static void init() {
        queue = new PriorityQueue<>();
        parent = new int[V + 1];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
    }

    private static int kruskal() {
        int useEdge = 0;
        int result = 0;
        while (useEdge < V - 1) {
            Edge now = queue.poll();
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                result += now.weight;
                useEdge++;
            }
        }

        return result;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    private static int find(int a) {
        if (a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
