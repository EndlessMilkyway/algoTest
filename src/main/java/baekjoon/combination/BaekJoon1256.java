package baekjoon.combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1256 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] D = new int[201][201];
        // D[i][j] = D[i - 1][j] + D[i - 1][j - 1]
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    D[i][j] = 1;
                } else {
                    D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
                    if (D[i][j] > 1000000000) D[i][j] = 1000000001;
                }
            }
        }
        if (D[N + M][M] < K) {
            sb.append(-1);
        } else {
            while (!(N == 0 && M == 0)) {
                if (D[N - 1 + M][M] >= K) {
                    sb.append("a");
                    N--;
                } else {
                    sb.append("z");
                    K = K - D[N - 1 + M][M];
                    M--;
                }
            }
        }
        System.out.println(sb);
    }
}
