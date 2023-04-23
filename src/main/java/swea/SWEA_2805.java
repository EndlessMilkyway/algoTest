package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Stream;

// 농작물 수확하기
public class SWEA_2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= t; testCase++)
        {
            int size = Integer.parseInt(br.readLine());
            int middleNum = size / 2;
            int sum = 0;
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i ++) {
                int[] row = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
                if (i == middleNum) { sum += Arrays.stream(row).sum(); }
                System.arraycopy(row, 0, matrix[i], 0, size);

            }

            for (int j = 1; j <= middleNum; j++) {
                for (int k = j; k <= size - 1 - j; k++) {
                    sum = sum + matrix[middleNum - j][k] + matrix[middleNum + j][k];
                }
            }

            bw.write("#" + testCase + " " + sum);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
