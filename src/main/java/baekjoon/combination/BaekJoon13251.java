package baekjoon.combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon13251 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = 0;
        for (int i = 1; i <= M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            T += arr[i];
        }

        int K = Integer.parseInt(br.readLine());
        double[] probability = new double[M + 1];
        double answer = 0.0;
        for (int i = 1; i <= M; i++) {
            if (arr[i] >= K) {
                probability[i] = 1.0;
                for (int k = 0; k < K; k++) {
                    probability[i] *= (double) (arr[i] - k) / (T - k);
                }
                answer += probability[i];
            }
        }

        System.out.println(answer);
    }
}
