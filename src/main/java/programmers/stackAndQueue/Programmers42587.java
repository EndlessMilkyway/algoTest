package programmers.stackAndQueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Programmers42587 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{2, 1, 3, 4, 4, 1}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    private static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int priority : priorities) {
            queue.add(priority);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    queue.poll();
                    answer++;
                }
            }
        }
        return 0;
    }

    public int solution2(int[] priorities, int location) {
        Queue<Pair> queue = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Pair(i, priorities[i]));
        }

        while (!queue.isEmpty()) {

            int current = queue.peek().value;

            boolean flag = false;

            for (Pair pair : queue) {
                if (pair.value > current) {
                    // System.out.println(pair.value);
                    flag = true;
                    break;
                }
            }

            if (flag) {
                Pair temp = queue.poll();
                queue.add(temp);
            } else {
                answer++;
                Pair pair = queue.poll();

                if (pair.index == location) {
                    return answer;
                }
            }
        }
        return answer;
    }

    static class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
