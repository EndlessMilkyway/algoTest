package baekjoon.bellmanford;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1219 {
    private static Edge[] edges;
    private static long[] distances;
    private static long[] cityMoney;
    private static int N;
    private static int startCity;
    private static int destCity;
    private static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        startCity = Integer.parseInt(st.nextToken());
        destCity = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, price);
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cityMoney[i] = Long.parseLong(st.nextToken());
        }
        bellmanFord();
        print();
    }

    private static void init() {
        edges = new Edge[M];
        distances = new long[N];
        cityMoney = new long[N];
        Arrays.fill(distances, Long.MIN_VALUE);
    }

    private static void print() {
        if (distances[destCity] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else if (distances[destCity] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else {
            System.out.println(distances[destCity]);
        }
    }

    private static void bellmanFord() {
        distances[startCity] = cityMoney[startCity];
        for (int i = 0; i <= N + 100; i++) {
            for (int j = 0; j < M; j++) {
                int start = edges[j].start;
                int end = edges[j].end;
                int price = edges[j].price;

                if (distances[start] == Long.MIN_VALUE) {
                    continue;
                } else if (distances[start] == Long.MAX_VALUE) {
                    distances[end] = Long.MAX_VALUE;
                } else if (distances[end] < distances[start] + cityMoney[end] - price) {
                    distances[end] = distances[start] + cityMoney[end] - price;
                    if (i >= N - 1) distances[end] = Long.MAX_VALUE;
                }
            }
        }
    }

    static class Edge {
        int start;
        int end;
        int price;

        public Edge(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }
    }
}
