package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class SWEA1244 {
    private static int[] info;
    private static int max, exchange;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());


        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            info = Stream.of(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
            exchange = Integer.parseInt(st.nextToken());
            max = 0;

            if (info.length < exchange) exchange = info.length;
            dfs(0, 0);

            sb.append("#").append(testCase).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int idx, int cnt) {
        if (cnt == exchange) {
            int result = 0;
            for (int digit : info) {
                result *= 10;
                result += digit;
            }
            max = Math.max(max, result);
            return;
        }
        for (int i = idx; i < info.length; i++) {
            for (int j = i + 1; j < info.length; j++) {
                int tmp = info[i];
                info[i] = info[j];
                info[j] = tmp;

                dfs(i, cnt + 1);

                tmp = info[i];
                info[i] = info[j];
                info[j] = tmp;
            }
        }
    }
}
