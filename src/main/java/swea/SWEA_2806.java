package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;

// N-queen
public class SWEA_2806 {
    private static int n;
    private static int[] loc;
    private static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= t; testCase++) {
            n = Integer.parseInt(br.readLine());
            loc = new int[n];
            cnt = 0;

            for (int i = 0; i < n; i++) {
                Array.setInt(loc, i, 0);
            }

            backtracking(0);

            bw.write("#" + testCase + " " + cnt);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void backtracking(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            loc[depth] = i;
            if (inspect(depth)) {
                backtracking(depth + 1);
            }
        }
    }

    private static boolean inspect(int col) {
        for (int i = 0; i < col; i++) {
            if (loc[col] == loc[i] || Math.abs(col - i) == Math.abs(loc[col] - loc[i])) { return false; }
        }
        return true;
    }
}
