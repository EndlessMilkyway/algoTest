package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2292 {
    public static void main(String[] args) throws IOException {
        System.out.println(logic(input()));
    }

    private static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return Integer.parseInt(br.readLine());
    }

    private static int logic(int N) {
        int tmp = 1;
        int cnt = 1;
        while (N > tmp) {
            tmp += 6 * cnt;
            cnt++;
        }

        return cnt;
    }
}
