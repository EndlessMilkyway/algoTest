package baekjoon.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BaekJoon1991 {
    private static List<Node> list;
    private static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int node = s[0].charAt(0) - 'A';
            int left = s[1].charAt(0) == '.' ? -1 : s[1].charAt(0) - 'A';
            int right = s[2].charAt(0) == '.' ? -1 : s[2].charAt(0) - 'A';
            list.add(new Node(node, left, right));
        }
        list.sort(Comparator.comparingInt(o -> o.current));

        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        sb.append("\n");

        System.out.println(sb);
    }

    private static void preOrder(int now) {
        if (now == -1)
            return;
        sb.append((char) (now + 'A'));
        preOrder(list.get(now).left);
        preOrder(list.get(now).right);
    }

    private static void inOrder(int now) {
        if (now == -1)
            return;
        inOrder(list.get(now).left);
        sb.append((char) (now + 'A'));
        inOrder(list.get(now).right);
    }

    private static void postOrder(int now) {
        if (now == -1)
            return;
        postOrder(list.get(now).left);
        postOrder(list.get(now).right);
        sb.append((char) (now + 'A'));
    }

    static class Node {
        int current;
        int left;
        int right;

        public Node(int current, int left, int right) {
            this.current = current;
            this.left = left;
            this.right = right;
        }
    }
}
