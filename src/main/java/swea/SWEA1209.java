package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1209 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[][] arr;
        int[] horizontalSum, verticalSum;
        int diagonalSum, diagonalSum2;

        for (int testCase = 1; testCase <= 10; testCase++) {
            int uselessInput = Integer.parseInt(br.readLine());
            arr = new int[100][100];
            horizontalSum = new int[100];
            verticalSum = new int[100];
            diagonalSum = 0;
            diagonalSum2 = 0;

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 100; i++) {
                diagonalSum += arr[i][i];
                diagonalSum2 += arr[i][99 - i];
                for (int j = 0; j < 100; j++) {
                    horizontalSum[i] += arr[i][j];
                    verticalSum[i] += arr[j][i];
                }
            }

            sb.append("#").append(testCase).append(" ").append(Math.max(Math.max(diagonalSum, diagonalSum2),
                    Math.max(Arrays.stream(horizontalSum).max().getAsInt(),
                            Arrays.stream(verticalSum).max().getAsInt()))).append("\n");
        }
        System.out.println(sb);
    }
}
