package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(trailingZeroes(N));
    }

    private static int trailingZeroes(int N) {
        int result = 0;
        while (N > 0) {
            N /= 5;
            result += N;
        }
        return result;
    }
}
