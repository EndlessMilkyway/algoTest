package baekjoon.bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon11657 {
    private static Edge[] edges;
    private static long[] distances;
    private static int N;
    private static int M;
    private static boolean mCycleExist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }
        bellmanFord();
        mCycleExist = checkMinusCycle();
        print();
    }

    private static void init() {
        edges = new Edge[M + 1];
        distances = new long[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
    }

    private static void bellmanFord() {
        distances[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if (distances[edge.start] != Integer.MAX_VALUE
                        && distances[edge.end] > distances[edge.start] + edge.time) {
                    distances[edge.end] = distances[edge.start] + edge.time;
                }
            }
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        if (!mCycleExist) {
            for (int i = 2; i <= N; i++) {
                if (distances[i] == Integer.MAX_VALUE) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(distances[i]).append("\n");
                }
            }
        } else {
            sb.append("-1");
        }
        System.out.println(sb);
    }

    private static boolean checkMinusCycle() {
        for (int j = 0; j < M; j++) {
            Edge edge = edges[j];
            if (distances[edge.start] != Integer.MAX_VALUE
                    && distances[edge.end] > distances[edge.start] + edge.time) {
                return true;
            }
        }
        return false;
    }

    static class Edge {
        int start;
        int end;
        int time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

}
