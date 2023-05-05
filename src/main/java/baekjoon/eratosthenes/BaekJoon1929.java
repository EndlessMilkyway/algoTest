package baekjoon.eratosthenes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1929 {
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(
                new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[end + 1];
        Arrays.fill(arr, 2, end + 1, true);

        for (int i = 2; i <= end; i++) {
            if (!arr[i]) continue;
            for (int j = 2 * i; j <= end; j += i) {
                arr[j] = false;
            }
        }

        for (int i = start; i <= end; i++) if (arr[i]) sb.append(i).append("\n");
        System.out.println(sb);
    }
}
