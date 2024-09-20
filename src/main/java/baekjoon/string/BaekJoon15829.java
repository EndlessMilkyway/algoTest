package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon15829 {
    private static final long r = 31L;
    private static final long M = 1234567891L;
    private static final long convertConst = 96L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        long sum = 0L;
        long pow = 1L;
        for (int i = 0; i < L; i++) {
            sum += (chars[i] - convertConst) * pow % M;
            pow = pow * r % M;
        }

        System.out.println(sum % M);
    }
}
