package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon1916 {
    private static boolean[] visited;
    private static int[] costs;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int M = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        costs = new int[N + 1];

        for (int k = 0; k < N + 1; k++) {
            costs[k] = Integer.MAX_VALUE;
        }

        costs[start] = 0;

        dijkstra(N, graph);

        System.out.println(costs[dest]);
    }

    private static void dijkstra(int N, ArrayList<ArrayList<Node>> graph) {
        for (int i = 0; i < N; i++) {
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;

            for (int j = 1; j < N + 1; j++) {
                if (!visited[j] && costs[j] < nodeValue) {
                    nodeValue = costs[j];
                    nodeIdx = j;
                }
            }

            visited[nodeIdx] = true;

            for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
                Node adjNode = graph.get(nodeIdx).get(j);

                if (costs[adjNode.idx] > costs[nodeIdx] + adjNode.cost) {
                    costs[adjNode.idx] = costs[nodeIdx] + adjNode.cost;
                }
            }
        }
    }

    static class Node {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
