package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1940 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        br.close();

        int pt1 = 0;
        int pt2 = n - 1;
        int cnt = 0;
        while (pt1 < pt2) {
            if (arr[pt1] + arr[pt2] < m) {
                pt1++;
                continue;
            }
            if (arr[pt1] + arr[pt2] > m) {
                pt2--;
                continue;
            }
            if (arr[pt1] + arr[pt2] == m) {
                pt1++;
                pt2--;
                cnt++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
}
