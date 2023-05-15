package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1753 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        int[] distance = new int[V + 1];
        boolean[] visited = new boolean[V + 1];
        List<List<Edge>> list = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(u).add(new Edge(v, w));
        }
        Queue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(K, 0));
        distance[K] = 0;
        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int vertex = current.vertex;
            if (visited[vertex]) {
                continue;
            }
            visited[vertex] = true;
            for (int i = 0; i < list.get(vertex).size(); i++) {
                Edge tmp = list.get(vertex).get(i);
                int next = tmp.vertex;
                int value = tmp.value;
                if (distance[next] > distance[vertex] + value) {
                    distance[next] = distance[vertex] + value;
                    queue.add(new Edge(next, distance[next]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int value;

        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge e) {
            if (this.value > e.value) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}
