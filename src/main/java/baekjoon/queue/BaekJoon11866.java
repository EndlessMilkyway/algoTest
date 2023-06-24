package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon11866 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
        System.out.println(logic(generateQueue(Integer.parseInt(st.nextToken())), Integer.parseInt(st.nextToken())));
    }

    private static Queue<Integer> generateQueue(int N) {
        return new LinkedList<>() {{
            for (int i = 1; i <= N; i++) {
                add(i);
            }
        }};
    }

    private static StringBuilder logic(Queue<Integer> queue, int K) {
        StringBuilder sb = new StringBuilder();

        sb.append("<");
        while (true) {
            if (queue.size() == 1) {
                sb.append(queue.poll()).append(">");
                break;
            }
            for (int i = 1; i < K; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }

        return sb;
    }
}
