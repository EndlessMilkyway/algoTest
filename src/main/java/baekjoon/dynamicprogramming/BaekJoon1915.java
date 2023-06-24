package baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1915 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] D = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                D[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
                if (D[i][j] == 1 && j > 0 && i > 0)
                    D[i][j] = Math.min(D[i - 1][j - 1], Math.min(D[i - 1][j], D[i][j - 1])) + D[i][j];
                if (max < D[i][j])
                    max = D[i][j];
            }
        }
        System.out.println(max * max);
    }
}
