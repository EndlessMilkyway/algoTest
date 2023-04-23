package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_2814 {
    private static int[][] graph;
    private static boolean[] visited;
    private static int n, m, depth;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            graph = new int[n + 1][n + 1];
            visited = new boolean[n + 1];
            depth = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = 1;
                graph[y][x] = 1;
            }

            for (int j = 1; j < n + 1; j++) {
                visited[j] = true;
                dfs(j, 1);
                visited[j] = false;
            }

            bw.write("#" + testCase + " " + depth);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void dfs(int vertex, int cnt) {
        depth = Math.max(depth, cnt);

        for (int i = 1; i < n + 1; i++) {
            if (graph[vertex][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
