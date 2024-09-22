package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon1874_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        int ascNum = 1;
        boolean result = true;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sequence.length; i++) {
            int currentNum = sequence[i];      // 현재 수열의 수
            if (currentNum >= ascNum) {        // 현재 수열 값 >= 오름차순 자연수: 값이 같아질 때까지 스택에 추가
                while (currentNum >= ascNum) { // push()
                    stack.push(ascNum++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {                    // 현재 수열 값 < 오름차순 자연수: pop()을 수행해 수열 원소를 꺼냄
                int poppedNum = stack.pop();
                if (poppedNum > currentNum) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if (result) {
            System.out.println(sb);
        }
        br.close();
    }
}
