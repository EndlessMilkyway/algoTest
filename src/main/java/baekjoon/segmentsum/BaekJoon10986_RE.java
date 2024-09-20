package baekjoon.segmentsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon10986_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] sumArr = new long[n];
        long[] countArr = new long[m];
        long answer = 0;
        sumArr[0] = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int remainder = (int) sumArr[i] % m;
            if (remainder == 0) answer++;
            countArr[remainder]++;
        }

        for (int i = 0; i < m; i++) {
            if (countArr[i] > 1) {
                answer += (countArr[i] * (countArr[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}
