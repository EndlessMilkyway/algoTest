package baekjoon.divideandconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon13172 {
    private static final long MOD = 1000000007L;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long result = 0;
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long b = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long d = gcd(a, b);

            a /= d;
            b /= d;

            result += a * modular(b, MOD - 2) % MOD;
            result %= MOD;
        }

        bw.write(result + "");
        bw.close();
    }

    private static long modular(long x, long y) {
        if (y == 1) {
            return x;
        }
        if (y % 2 == 0) {
            long p = modular(x, y / 2);
            return p * p % MOD;
        }
        return x * modular(x, y - 1) % MOD;
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

