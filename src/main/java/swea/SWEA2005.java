package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2005 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[][] arr;

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i == j) {
                        arr[i][j] = 1;
                    } else if (j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                    }
                }
            }
            sb.append("#").append(testCase).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
