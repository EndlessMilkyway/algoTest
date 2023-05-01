package baekjoon.slidingwindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class BaekJoon11003 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Deque<Node> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int currentVal = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.getLast().value > currentVal) {
                deque.removeLast();
            }
            deque.addLast(new Node(currentVal, i));
            if (deque.getFirst().index <= i - l) deque.removeFirst();
            bw.write(deque.getFirst().value + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static class Node {
        public int value;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
