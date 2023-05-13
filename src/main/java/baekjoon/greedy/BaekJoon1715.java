package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BaekJoon1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(br.readLine());
            queue.add(data);
        }
        int sum = 0;
        while (queue.size() != 1) {
            int result = queue.remove() + queue.remove();
            sum += result;
            queue.add(result);
        }
        System.out.println(sum);
    }
}