package baekjoon.euclidean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon21568 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long gcd = gcd(a, b);
        if (c % gcd != 0) {
            System.out.println(-1);
        } else {
            int quotient = (int) (c / gcd);
            long[] result = logic(a, b);
            System.out.println(result[0] * quotient + " " + result[1] * quotient);
        }
    }

    private static long[] logic(long a, long b) {
        long[] result = new long[2];
        if (b == 0) {
            result[0] = 1;
            result[1] = 0;
            return result;
        }
        long q = a / b;
        long[] v = logic(b, a % b);
        result[0] = v[1];
        result[1] = v[0] - v[1] * q;
        return result;
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return Math.abs(a);
    }

//    private static long gcd(long a, long b) {
//        if (b == 0) {
//            return a;
//        } else {
//            return gcd(b, a % b);
//        }
//    }
}
