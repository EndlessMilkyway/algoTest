package programmers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Programmers42626 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,9,10,12}, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        int minVal;

        //Queue<Integer> queue = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        Queue<Integer> queue = new PriorityQueue<>();

        for (int food : scoville) {
            queue.offer(food);
        }

        minVal = queue.peek();
        while (K > minVal && queue.size() > 1) {
            queue.offer(queue.poll() + (queue.poll() * 2));
            answer++;
            minVal = queue.peek();
        }

        if (K > minVal) {
            answer = -1;
        }

        return answer;
    }
}
