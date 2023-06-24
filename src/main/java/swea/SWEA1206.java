package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] height;
        int current;
        long cnt;

        for (int testCase = 1; testCase <= 10; testCase++) {
            int N = Integer.parseInt(br.readLine());
            height = new int[N];
            cnt = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 2; i <= N - 3; i++) {
                current = height[i];
                int max = Math.max(height[i - 2], Math.max(height[i - 1], Math.max(height[i + 1], height[i + 2])));
                if (current > max) cnt += current - max;
            }
            sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
