package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class BaekJoon10845 {
    private static Deque<Integer> queue;

    public static void main(String[] args) throws IOException {
        queue = new LinkedList<>();
        System.out.println(logic());
    }

    private static StringBuilder logic() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
                continue;
            }
            sb.append(handleCommand(command)).append("\n");
        }

        return sb;
    }

    private static int handleCommand(String command) {
        if (Objects.equals(command, "pop")) {
            return pop();
        } else if (Objects.equals(command, "size")) {
            return size();
        } else if (Objects.equals(command, "empty")) {
            return isEmpty();
        } else if (Objects.equals(command, "front")) {
            return pollFront();
        } else {
            return pollBack();
        }
    }

    private static int pop() {
        if (!queue.isEmpty()) {
            return queue.poll();
        }
        return -1;
    }

    private static int size() {
        return queue.size();
    }

    private static int isEmpty() {
        if (queue.isEmpty()) {
            return 1;
        }
        return 0;
    }

    private static int pollFront() {
        if (!queue.isEmpty()) {
            return queue.peekFirst();
        }
        return -1;
    }

    private static int pollBack() {
        if (!queue.isEmpty()) {
            return queue.peekLast();
        }
        return -1;
    }
}
