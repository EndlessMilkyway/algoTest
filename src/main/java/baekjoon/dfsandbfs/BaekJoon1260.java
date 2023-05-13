package baekjoon.dfsandbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1260 {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<List<Integer>> list;
    private static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            list.get(e).add(s);
        }

        for (int i = 1; i <= n; i++) {
            list.get(i).sort(Integer::compareTo);
        }

        visited = new boolean[n + 1];
        dfs(v);
        bw.newLine();
        visited = new boolean[n + 1];
        bfs(v);
        bw.newLine();
        bw.flush();
    }

    private static void dfs(int node) throws IOException {
        bw.write(node + " ");
        visited[node] = true;
        for (int i : list.get(node)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int node) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            bw.write(currentNode + " ");
            for (int i : list.get(currentNode)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
