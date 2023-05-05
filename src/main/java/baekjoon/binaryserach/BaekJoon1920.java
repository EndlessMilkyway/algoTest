package baekjoon.binaryserach;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] dict = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) dict[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(dict);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int start = 0, end = n - 1, result = 0, i = Integer.parseInt(st.nextToken());
            while (start <= end) {
                int mid = (start + end) / 2;
                if (dict[mid] < i) {
                    start = mid + 1;
                } else if (dict[mid] > i) {
                    end = mid - 1;
                } else {
                    result = 1;
                    break;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
