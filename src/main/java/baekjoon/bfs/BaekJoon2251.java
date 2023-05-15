package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2251 {
    private static final int[] from = {0, 0, 1, 1, 2, 2};
    private static final int[] to = {1, 2, 0, 2, 0, 1};
    private static boolean[][] visited;
    private static boolean[] answer;
    private static int[] current;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
        StringBuilder sb = new StringBuilder();
        current = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())};
        visited = new boolean[201][201];
        answer = new boolean[201];
        bfs();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[current[2]] = true;
        while (!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = current[2] - A - B;
            for (int k = 0; k < 6; k++) {
                int[] next = {A, B, C};
                next[to[k]] += next[from[k]];
                next[from[k]] = 0;
                if (next[to[k]] > current[to[k]]) {
                    next[from[k]] = next[to[k]] - current[to[k]];
                    next[to[k]] = current[to[k]];
                }
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    static class AB {
        int A;
        int B;

        public AB(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }
}
