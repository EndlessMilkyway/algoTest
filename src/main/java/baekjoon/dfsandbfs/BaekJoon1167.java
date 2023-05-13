package baekjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1167 {
    private static boolean[] visited;
    private static int[] distance;
    private static List<List<Edge>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int v = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                list.get(start).add(new Edge(node, weight));
            }
        }

        distance = new int[v + 1];
        visited = new boolean[v + 1];
        bfs(1);
        int max = 1;
        for (int i = 2; i <= v; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }

        distance = new int[v + 1];
        visited = new boolean[v + 1];
        bfs(max);
        Arrays.sort(distance);
        System.out.println(distance[v]);
    }

    private static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (Edge item : list.get(currentNode)) {
                int node = item.node;
                int weight = item.weight;
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    distance[node] = distance[currentNode] + weight;
                }
            }
        }
    }

    static class Edge {
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
