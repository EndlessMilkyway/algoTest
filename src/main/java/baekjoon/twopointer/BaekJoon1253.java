package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1253 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int result = 0;
        for (int k = 0; k < n; k++) {
            long find = arr[k];
            int i = 0;
            int j = n - 1;
            while (i < j) {
                if (arr[i] + arr[j] == find) {
                    if (i != k && j != k) {
                        result++;
                        break;
                    }
                    if (i == k) {
                        i++;
                        continue;
                    }
                    if (j == k) {
                        j--;
                        continue;
                    }
                }
                if (arr[i] + arr[j] < find) {
                    i++;
                    continue;
                }
                if (arr[i] + arr[j] > find) {
                    j--;
                }
            }
        }
        System.out.println(result);
    }
}
