package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon18110 {
    private static final double trimmedRatio = 0.15;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] opinions = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            opinions[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(opinions);

        int exceptCnt = (int) Math.round(n * trimmedRatio);
        int sum = 0;
        for (int i = exceptCnt + 1; i <= n - exceptCnt; i++) {
            sum += opinions[i];
        }

        System.out.println((int) Math.round((double) sum / (n - 2 * exceptCnt)));
    }
}
