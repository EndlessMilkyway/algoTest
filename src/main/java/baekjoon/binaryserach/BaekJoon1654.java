package baekjoon.binaryserach;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1654 {
    private static int[] arr;
    private static int k, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long start = 0, end = Integer.MAX_VALUE, answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (logic(mid)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean logic(long m) {
        long sum = 0;
        for (int i : arr) {
            if (i >= m) {
                sum += i / m;
            }
        }
        return sum >= n;
    }
}
