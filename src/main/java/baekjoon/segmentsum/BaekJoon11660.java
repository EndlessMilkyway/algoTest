package baekjoon.segmentsum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon11660 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] segmentArr = new int[n + 1][n + 1];
        for (int j = 1; j < n + 1; j++) {
            for (int k = 1; k < n + 1; k++) {
                segmentArr[j][k] = segmentArr[j][k - 1] + segmentArr[j - 1][k] - segmentArr[j - 1][k - 1] + arr[j][k];
            }
        }

        for (int l = 0; l < m; l++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            bw.write(segmentArr[x2][y2] - segmentArr[x1 - 1][y2] - segmentArr[x2][y1 - 1]
                    + segmentArr[x1 - 1][y1 - 1] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
