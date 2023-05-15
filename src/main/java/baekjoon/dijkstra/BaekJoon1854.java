package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1854 {
    private static List<Node>[] A;
    private static PriorityQueue<Integer>[] dist;
    private static int N, M, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new PriorityQueue[N + 1];
        for (int i = 0; i <= N; i++) {
            dist[i] = new PriorityQueue<>(K, (o1, o2) -> o1 < o2 ? 1 : -1);
        }
        A = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            A[a].add(new Node(b, c));
        }
        dijkstra();
        for (int i = 1; i <= N; i++) {
            if (dist[i].size() == K) {
                sb.append(dist[i].peek()).append("\n");
            } else {
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void dijkstra() {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        dist[1].add(0);
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node next : A[cur.node]) {
                if (dist[next.node].size() < K) {
                    dist[next.node].add(cur.cost + next.cost);
                    pq.add(new Node(next.node, cur.cost + next.cost));
                } else if (dist[next.node].peek() > cur.cost + next.cost) {
                    dist[next.node].poll();
                    dist[next.node].add(cur.cost + next.cost);
                    pq.add(new Node(next.node, cur.cost + next.cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost < o.cost ? -1 : 1;
        }
    }

}
