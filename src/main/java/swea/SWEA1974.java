package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA1974 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        int[][] board;
        int horizontalSum, verticalSum, blockSum;

        for (int testCase = 1; testCase <= t; testCase++) {
            board = new int[9][9];

            int result = 1;

            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 9; j++)
                    board[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < 9; i++) {
                horizontalSum = 0;
                verticalSum = 0;
                for (int j = 0; j < 9; j++) {
                    horizontalSum += board[i][j];
                    verticalSum += board[j][i];
                }
                if (horizontalSum != 45 || verticalSum != 45) {
                    result = 0;
                    break;
                }
            }

            for (int i = 0; i <= 6; i += 3) {
                for (int j = 0; j <= 6; j += 3) {
                    int[] arr = new int[9];
                    for (int a = i; a < i + 3; a++) {
                        for (int b = j; b < j + 3; b++) {
                            arr[(board[a][b] - 1)]++;
                        }
                    }

                    for (int z = 0; z < 9; z++) {
                        if (arr[z] == 0) {
                            result = 0;
                            break;
                        }
                    }
                }
            }

            bw.write("#" + testCase + " " + result);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
