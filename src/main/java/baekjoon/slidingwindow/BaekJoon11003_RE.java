package baekjoon.slidingwindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BaekJoon11003_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Deque<Node> deque = new LinkedList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int currentNum = Integer.parseInt(st.nextToken());

            // 현재 수보다 큰 값을 덱에서 제거 -> 시간 복잡도 감소
            while (!deque.isEmpty() && deque.getLast().val > currentNum) {
                deque.removeLast();
            }

            // 덱에 노드 추가
            deque.addLast(new Node(i, currentNum));

            // 범위에서 벗어난 값은 덱에서 제거
            if (deque.getFirst().idx <= i - l) {
                deque.removeFirst();
            }
            bw.write(deque.getFirst().val + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static class Node {
        public int idx;
        public int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
