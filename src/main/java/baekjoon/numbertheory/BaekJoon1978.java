package baekjoon.numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[1001];
        Arrays.fill(prime, 2, 1001, true);

        for (int i = 2; i <= 1000; i++) {
            if (!prime[i]) continue;
            for (int j = 2 * i; j <= 1000; j += i)
                prime[j] = false;
        }

        int cnt = 0;
        for (int num : arr) if (prime[num]) cnt++;
        System.out.println(cnt);
    }
}
