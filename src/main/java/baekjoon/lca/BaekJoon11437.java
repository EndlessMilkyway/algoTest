package baekjoon.lca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon11437 {
    private static ArrayList<Integer>[] tree;
    private static int[] depthArr, parentArr;
    private static boolean[] visited;
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        init();
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        bfs(1);
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(findLCA(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    private static void init() {
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            tree[i] = new ArrayList<>();
        depthArr = new int[N + 1];
        parentArr = new int[N + 1];
        visited = new boolean[N + 1];
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        int depth = 1;
        int currentSize = 1;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int next : tree[currentNode]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parentArr[next] = currentNode;
                    depthArr[next] = depth;
                }
            }
            cnt++;
            if (cnt == currentSize) {
                cnt = 0;
                currentSize = queue.size();
                depth++;
            }
        }
    }

    private static int findLCA(int a, int b) {
        if (depthArr[a] < depthArr[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (depthArr[a] != depthArr[b]) a = parentArr[a];
        while (a != b) {
            a = parentArr[a];
            b = parentArr[b];
        }
        return a;
    }
}
