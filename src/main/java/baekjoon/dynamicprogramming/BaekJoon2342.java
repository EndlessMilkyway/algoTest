package baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2342 {
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
        int[][][] dp = new int[100001][5][5];
        int[][] mp = {{0, 2, 2, 2, 2},
                {2, 1, 3, 4, 3},
                {2, 3, 1, 3, 4},
                {2, 4, 3, 1, 3},
                {2, 3, 4, 3, 1}};
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                for (int k = 0; k < 100001; k++)
                    dp[k][i][j] = 100001 * 4;
        dp[0][0][0] = 0;

        int n;
        int s = 1;
        while (true) {
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            for (int i = 0; i < 5; i++) {
                if (n == i)
                    continue;
                for (int j = 0; j < 5; j++)
                    dp[s][i][n] = Math.min(dp[s - 1][i][j] + mp[j][n], dp[s][i][n]);
            }
            for (int j = 0; j < 5; j++) {
                if (n == j)
                    continue;
                for (int i = 0; i < 5; i++)
                    dp[s][n][j] = Math.min(dp[s - 1][i][j] + mp[i][n], dp[s][n][j]);
            }
            s++;
        }
        s--;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                min = Math.min(min, dp[s][i][j]);
        System.out.println(min);
    }
}
