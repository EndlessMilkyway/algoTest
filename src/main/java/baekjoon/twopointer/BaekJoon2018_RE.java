package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2018_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 1;
        int start_idx = 1;
        int end_idx = 1;
        int sum = 1;

        while (end_idx != n) {
            if (sum == n) {
                cnt++;
                end_idx++;
                sum += end_idx;
            } else if (sum > n) {
                sum -= start_idx;
                start_idx++;
            } else {
                end_idx++;
                sum += end_idx;
            }
        }

        System.out.println(cnt);
    }
}
