package baekjoon.segmentsum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BeakJoon10986 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        long[] count = new long[m];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < n; j++) {
            int tmp = (int) (arr[j] % m);
            if (tmp == 0) answer++;
            count[tmp]++;
        }

        for (int k = 0; k < m; k++) {
            if (count[k] > 1) {
                answer = answer + (count[k] * (count[k] - 1) / 2);
            }
        }

        br.close();
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}
