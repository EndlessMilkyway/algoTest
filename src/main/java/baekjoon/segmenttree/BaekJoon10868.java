package baekjoon.segmenttree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon10868 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long[] tree;
    private static int N, M;
    private static int treeSize, leafNodeStartIdx;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();
        makeTree();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            s += leafNodeStartIdx;
            e += leafNodeStartIdx;
            sb.append(getMin(s, e)).append("\n");
        }
        System.out.println(sb);
    }

    private static void init() {
        int height = 0;
        int length = N;
        while (length != 0) {
            length /= 2;
            height++;
        }
        treeSize = (int) Math.pow(2, height + 1);
        leafNodeStartIdx = treeSize / 2 - 1;
        tree = new long[treeSize + 1];
        Arrays.fill(tree, Integer.MAX_VALUE);
    }

    private static void makeTree() throws IOException {
        for (int i = leafNodeStartIdx + 1; i <= leafNodeStartIdx + N; i++)
            tree[i] = Integer.parseInt(br.readLine());
        int tmp = treeSize - 1;
        while (tmp != 1) {
            if (tree[tmp / 2] > tree[tmp])
                tree[tmp / 2] = tree[tmp];
            tmp--;
        }
    }

    private static long getMin(int s, int e) {
        long result = Long.MAX_VALUE;
        while (s <= e) {
            if (s % 2 == 1) {
                result = Math.min(result, tree[s]);
                s++;
            }
            s /= 2;
            if (e % 2 == 0) {
                result = Math.min(result, tree[e]);
                e--;
            }
            e /= 2;
        }
        return result;
    }
}
