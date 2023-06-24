package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1859 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int N;
        int[] price;
        int max;
        long income;

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            price = new int[N];
            income = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            max = price[N - 1];
            for (int i = N - 2; i >= 0; i--) {
                if (max > price[i]) {
                    income += max - price[i];
                } else {
                    max = price[i];
                }
            }

            sb.append("#").append(t).append(" ").append(income).append("\n");
        }
        System.out.println(sb);
    }
}
