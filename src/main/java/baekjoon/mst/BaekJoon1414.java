package baekjoon.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1414 {
    private static int N, sum, useEdge, result;
    private static int[] parent;
    private static Queue<Edge> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        init();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), "");
            char[] inputs = st.nextToken().toCharArray();
            for (int j = 0; j < N; j++) {
                int tmp = 0;
                if (inputs[j] >= 'a' && inputs[j] <= 'z') tmp = inputs[j] - 'a' + 1;
                else if (inputs[j] >= 'A' && inputs[j] <= 'Z') tmp = inputs[j] - 'A' + 27;
                sum += tmp;
                if (i != j && tmp != 0) queue.add(new Edge(i, j, tmp));
            }
        }
        kruskal();
        print();
    }

    private static void init() {
        queue = new PriorityQueue<>();
        parent = new int[N];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
    }

    private static void print() {
        if (useEdge == N - 1) System.out.println(sum - result);
        else System.out.println(-1);
    }

    private static void kruskal() {
        useEdge = 0;
        result = 0;
        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            if (find(now.s) != find(now.e)) {
                union(now.s ,now.e);
                result += now.v;
                useEdge++;
            }
        }
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
        int s, e, v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return this.v - o.v;
        }
    }
}
