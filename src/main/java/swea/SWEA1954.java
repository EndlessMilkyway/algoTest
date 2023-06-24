package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1954 {
    private static final int[] dr = {0, 1, 0, -1};
    private static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[][] arr;
        int dir, r, c;

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            dir = 0;
            r = 0;
            c = 0;

            for (int i = 1; i <= N * N; i++) {
                arr[r][c] = i;
                if (r + dr[dir] >= N || r + dr[dir] < 0 || c + dc[dir] >= N || c + dc[dir] < 0 || arr[r + dr[dir]][c + dc[dir]] != 0) {
                    dir = (dir + 1) % 4;
                }
                r += dr[dir];
                c += dc[dir];
            }

            sb.append("#").append(testCase).append("\n");
            for (int i = 0; i < N; i++) {
                for (int n : arr[i])
                    sb.append(n).append(" ");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
