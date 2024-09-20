package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2869 {
    private static final int AMOUNT = 3;

    public static void main(String[] args) throws IOException {
        System.out.println(logic(input()));
    }

    private static int[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[AMOUNT];

        for (int i = 0; i < AMOUNT; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        return input;
    }

    private static int logic(int[] input) {
        if (input[2] < input[1]) return 1;
        int tmp = (input[2] - input[0]) / (input[0] - input[1]);
        return (input[2] - input[0]) % (input[0] - input[1]) == 0 ? tmp + 1 : tmp + 2;
    }
}
