package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1018 {
    private static char[][] arr;
    private static int minVal = 64;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                logic(i, j);
            }
        }

        System.out.println(minVal);
    }

    private static void logic(int x, int y) {
        int cnt = 0;
        char c = arr[x][y];
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (arr[i][j] != c) cnt++;
                c = change(c);
            }
            c = change(c);
        }

        cnt = Math.min(cnt, 64 - cnt);
        minVal = Math.min(minVal, cnt);
    }

    private static char change(char c) {
        if (c == 'B') return 'W';
        return 'B';
    }
}
