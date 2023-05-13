package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon2023 {
    private static int n;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    private static void dfs(int num, int position) {
        if (position == n) {
            //if (isPrime(num)) {
                System.out.println(num);
            //}
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (isPrime(num * 10 + i)) {
                dfs(num * 10 + i, position + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        // for (int i = 2; i <= num / 2; i++) {
        for (int i = 2; i <= Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

