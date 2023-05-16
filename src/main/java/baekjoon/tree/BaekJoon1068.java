package baekjoon.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon1068 {
    private static ArrayList<Integer>[] tree;
    private static boolean[] visited;
    private static int answer;
    private static int deleteNode;
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        init();
        int root = 0;
        for (int i = 0; i < N; i++) tree[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p != -1) {
                tree[i].add(p);
                tree[p].add(i);
            } else {
                root = i;
            }
        }
        deleteNode = Integer.parseInt(br.readLine());
        if (deleteNode == root) System.out.println(0);
        else {
            dfs(root);
            System.out.println(answer);
        }
    }

    private static void init() {
        tree = new  ArrayList[N];
        visited = new boolean[N];
        answer = 0;
        deleteNode = 0;
    }

    private static void dfs(int num) {
        visited[num] = true;
        int cNode = 0;
        for (int i : tree[num]) {
            if (!visited[i] && i != deleteNode) {
                cNode++;
                dfs(i);
            }
        }
        if (cNode == 0) answer++;
    }
}
