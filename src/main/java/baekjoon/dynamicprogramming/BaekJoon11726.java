package baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon11726 {
    private static final long MOD = 10007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] D = new long[n + 1];
        D[1] = 1;
        D[2] = 2;
        for (int i = 3; i <= n; i++)
            D[i] = (D[i - 1] + D[i - 2]) % MOD;
        System.out.println(D[n]);
    }
}
