package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class BaekJoon1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minusQ = new PriorityQueue<>();
        int one = 0;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(br.readLine());
            if (data > 1) {
                plusQ.add(data);
            } else if (data == 1) {
                one++;
            } else if (data == 0) {
                zero++;
            } else {
                minusQ.add(data);
            }
        }

        int sum = 0;
        while (plusQ.size() > 1) {
            sum += (plusQ.remove() * plusQ.remove());
        }
        if (!plusQ.isEmpty()) {
            sum += plusQ.remove();
        }
        while (minusQ.size() > 1) {
            sum += (minusQ.remove() * minusQ.remove());
        }
        if (!minusQ.isEmpty()) {
            if (zero == 0) {
                sum += minusQ.remove();
            }
        }

        sum += one;
        System.out.println(sum);
    }
}
