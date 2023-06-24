package baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1328 {
    private static final long MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        long[][][] D = new long[N + 1][N + 1][N + 1];
        D[1][1][1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= L; j++) {
                for (int k = 1; k <= R; k++) {
                    D[i][j][k] = (D[i - 1][j - 1][k] + D[i - 1][j][k - 1] + D[i - 1][j][k] * (i - 2)) % MOD;
                }
            }
        }
        System.out.println(D[N][L][R]);
    }
}
