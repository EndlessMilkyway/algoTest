package baekjoon.combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11050 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i][1] = i;
            arr[i][0] = 1;
            arr[i][i] = 1;
        }
        for (int i = 2; i <= n; i++)
            for (int j = 1; j < i; j++)
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
        System.out.println(arr[n][k]);
    }
}
