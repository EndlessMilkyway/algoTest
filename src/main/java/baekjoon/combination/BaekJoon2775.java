package baekjoon.combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon2775 {
    /**
     * 점화식 도출
     * N[a][b] = N[a - 1][1] + ... + N[a - 1][b - 1] + N[a - 1][b]
     *         = N[a][b - 1] + N[a - 1][b]
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[15][15];
        // 배열 초기화
        for (int i = 0; i < 15; i++) {
            arr[i][1] = 1;
            arr[0][i] = i;
        }
        // 점화식을 이용해 각 집에 필요한 인원 계산
        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[k][n]).append("\n");
        }
        System.out.println(sb);
    }
}
