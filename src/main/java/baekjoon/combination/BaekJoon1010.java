package baekjoon.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1010 {
    // D[i][j] = D[i - 1][j - 1] + D[i - 1][j]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[31][31];
        for (int i = 0; i <= 30; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
            arr[i][1] = i;
        }
        for (int i = 2; i <= 30; i++)
            for (int j = 1; j < i; j++)
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(arr[M][N]).append("\n");
        }
        System.out.println(sb);
    }
}
