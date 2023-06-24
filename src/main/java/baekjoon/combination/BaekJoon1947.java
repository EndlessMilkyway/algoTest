package baekjoon.combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon1947 {
    private static long MOD = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] D = new long[1000001];
        D[1] = 0;
        D[2] = 1;
        for (int i = 3; i <= N; i++) {
            D[i] = (i - 1) * (D[i - 1] + D[i - 2]) % MOD;
        }
        System.out.println(D[N]);
    }
}
