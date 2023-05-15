package baekjoon.bipartitegraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BaekJoon1707 {
    private static List<List<Integer>> list;
    private static int[] check;
    private static boolean[] visited;
    private static boolean isEven;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int t = 0; t < n; t++) {
            String[] sArr = br.readLine().split(" ");
            int v = Integer.parseInt(sArr[0]);
            int e = Integer.parseInt(sArr[1]);
            list = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                list.add(new ArrayList<>());
            }
            visited = new boolean[v + 1];
            check = new int[v + 1];
            isEven = true;
            for (int i = 0; i < e; i++) {
                sArr = br.readLine().split(" ");
                int start = Integer.parseInt(sArr[0]);
                int end = Integer.parseInt(sArr[1]);
                list.get(start).add(end);
                list.get(end).add(start);
            }
            for (int i = 1; i <= v; i++) {
                if (isEven) {
                    dfs(i);
                } else {
                    break;
                }
            }
            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (int i : list.get(node)) {
            if (!visited[i]) {
                check[i] = (check[node] + 1) % 2;
                dfs(i);
            } else if (check[node] == check[i]) {
                isEven = false;
            }
        }
    }
}
