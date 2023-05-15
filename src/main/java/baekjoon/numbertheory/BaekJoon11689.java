package baekjoon.numbertheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 오일러 피
public class BaekJoon11689 {
    public static void main(String[] args) throws Exception {
        long n = Long.parseLong(new BufferedReader(new InputStreamReader(System.in)).readLine());
        long result = n;
        for (long p = 2; p <= Math.sqrt(n); p++) {
            if (n % p == 0) {
                result = result - result / p;
                while (n % p == 0)
                    n /= p;
            }
        }
        if (n > 1)
            result = result - result / n;
        System.out.println(result);
    }
}
