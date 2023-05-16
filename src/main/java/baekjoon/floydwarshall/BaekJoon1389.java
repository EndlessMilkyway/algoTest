package baekjoon.floydwarshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1389 {
    private static final int INF = 10000001;
    private static int N;
    private static int M;
    private static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            matrix[s][e] = 1;
            matrix[e][s] = 1;
        }
        floydWarshall();
        System.out.print(findKevinBacon());
    }

    private static void floydWarshall() {
        for (int k = 1; k <= N; k++)
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j])
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
    }

    private static int findKevinBacon() {
        int min = Integer.MAX_VALUE;
        int answer = -1;

        for (int i = 1; i <= N; i++) {
            int tmp = 0;
            for (int j = 1; j <= N; j++)
                tmp += matrix[i][j];

            if (min > tmp) {
                min = tmp;
                answer = i;
            }
        }

        return answer;
    }

    private static void init() {
        matrix = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) matrix[i][j] = 0;
                else matrix[i][j] = INF;
            }
        }
    }
}
