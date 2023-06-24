package baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2098 {
    private static final int INF = 1000000 * 16 + 1;
    private static int N;
    private static int[][] W;
    private static int[][] D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        W = new int[16][16];
        D = new int[16][1 << 16];

        // 비용 행렬 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++)
                W[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(tsp(0, 1));
    }

    private static int tsp(int c, int v) {
        if (v == (1 << N) - 1)      // 모든 노드를 방문한 경우
            return W[c][0] == 0 ? INF : W[c][0];

        if (D[c][v] != 0)           // 이미 방문한 노드인 경우 -> 이미 계산한 경우 바로 리턴 (메모이제이션)
            return D[c][v];

        int minVal = INF;
        for (int i = 0; i < N; i++)
            if ((v & (1 << i)) == 0 && W[c][i] != 0)    // 방문한적이 없고 갈 수 있는 도시인 경우
                minVal = Math.min(minVal, tsp(i, (v | (1 << i))) + W[c][i]);

        D[c][v] = minVal;
        return D[c][v];
    }
}
