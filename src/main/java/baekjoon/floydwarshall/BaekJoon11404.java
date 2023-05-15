package baekjoon.floydwarshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11404 {
    private static int INF = 10000001;
    private static int n;
    private static int m;
    private static int[][] matrix;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        init();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (matrix[start][end] > cost) {
                matrix[start][end] = cost;
            }
        }
        floydWarshall();
        print();
    }

    private static void init() {
        matrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = INF;
                }
            }
        }
    }

    private static void print() {
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= n; j++) {
                if (matrix[i][j] == INF) {
                    sb.append("0 ");
                } else {
                    sb.append(matrix[i][j]).append(" ");
                }
            }
            System.out.println(sb);
        }
    }

    private static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
    }
}
