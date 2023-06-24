package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int N, M, max, sum;
        int[][] arr;

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            max = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    sum = 0;
                    for (int k = i; k < i + M; k++)
                        for (int l = j; l < j + M; l++)
                            sum += arr[k][l];
                    max = Math.max(max, sum);
                }
            }

            sb.append("#").append(testCase).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
