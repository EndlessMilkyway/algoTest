package baekjoon.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class BaekJoon10866 {
    private static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        deque = new LinkedList<>();
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

                if (Objects.equals(command, "push_front")) {
                    deque.addFirst(num);
                } else {
                    deque.addLast(num);
                }

                continue;
            }
            sb.append(handleCommand(command)).append("\n");
        }

        return sb;
    }

    private static int handleCommand(String command) {
        if (Objects.equals(command, "pop_front")) {
            return popFront();
        } else if (Objects.equals(command, "pop_back")) {
            return popBack();
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

    private static int popFront() {
        if (!deque.isEmpty()) {
            return deque.removeFirst();
        }
        return -1;
    }

    private static int popBack() {
        if (!deque.isEmpty()) {
            return deque.removeLast();
        }
        return -1;
    }

    private static int size() {
        return deque.size();
    }

    private static int isEmpty() {
        if (deque.isEmpty()) {
            return 1;
        }
        return 0;
    }

    private static int pollFront() {
        if (!deque.isEmpty()) {
            return deque.peekFirst();
        }
        return -1;
    }

    private static int pollBack() {
        if (!deque.isEmpty()) {
            return deque.peekLast();
        }
        return -1;
    }
}
