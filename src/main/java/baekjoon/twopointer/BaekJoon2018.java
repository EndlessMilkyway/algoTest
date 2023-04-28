package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon2018 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int cnt = 1;
        int startIdx = 1;
        int endIdx = 1;
        int sum = 1;

        while (endIdx != n) {
            if (sum == n) {
                cnt++;
                endIdx++;
                sum += endIdx;
            }

            if (sum > n) {
                sum -= startIdx;
                startIdx++;
            }

            if (sum < n) {
                endIdx++;
                sum = sum + endIdx;
            }
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
}
