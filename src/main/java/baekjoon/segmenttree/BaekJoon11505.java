package baekjoon.segmenttree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon11505 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int treeSize, leafNodeStartIdx;
    private static long[] tree;
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        init();
        makeTree();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                changeVal(leafNodeStartIdx + b, c);
            } else if (a == 2) {
                b += leafNodeStartIdx;
                c += leafNodeStartIdx;
                sb.append(getMul(b, (int) c)).append("\n");
            } else {
                return;
            }
        }
        br.close();
        System.out.print(sb);
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
        Arrays.fill(tree, 1);
    }

    private static void makeTree() throws IOException {
        for (int i = leafNodeStartIdx + 1; i <= leafNodeStartIdx + N; i++)
            tree[i] = Integer.parseInt(br.readLine());
        int tmp = treeSize - 1;
        while (tmp != 1) {
            tree[tmp / 2] = tree[tmp / 2] * tree[tmp] % MOD;
            tmp--;
        }
    }

    private static void changeVal(int idx, long val) {
        tree[idx] = val;
        while (idx > 1) {
            idx /= 2;
            tree[idx] = tree[idx * 2] % MOD * tree[idx * 2 + 1] % MOD;
        }
    }

    private static long getMul(int s, int e) {
        long partMul = 1;
        while (s <= e) {
            if (s % 2 == 1) {
                partMul = partMul * tree[s] % MOD;
                s++;
            }
            if (e % 2 == 0) {
                partMul = partMul * tree[e] % MOD;
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return partMul;
    }
}
