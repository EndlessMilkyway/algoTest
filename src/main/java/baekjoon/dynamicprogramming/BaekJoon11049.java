package baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon11049 {
    private static int N;
    private static Matrix[] M;
    private static int[][] D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = new Matrix[N + 1];
        D = new int[N + 1][N + 1];
        for (int[] arr : D)
            Arrays.fill(arr, -1);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            M[i] = new Matrix(y, x);
        }

        System.out.println(execute(1, N));
    }

    private static int execute(int s, int e) {
        int result = Integer.MAX_VALUE;
        if (D[s][e] != -1)          // 계산했던 부분이면 다시 계산하지 않음(메모이제이션)
            return D[s][e];
        if (s == e)                 // 행렬 1개의 곱셈 연산의 수
            return 0;
        if (s + 1 == e)             // 행렬 2개의 곱셈 연산의 수
            return M[s].row * M[s].column * M[e].column;
        for (int i = s; i < e; i++) // 행렬 3개의 곱셈 연산의 수
            result = Math.min(result, M[s].row * M[i].column * M[e].column + execute(s, i) + execute(i + 1, e));
        return D[s][e] = result;
    }

    static class Matrix {
        int row;
        int column;

        public Matrix(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

}
