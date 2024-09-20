package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> book = new Stack<>();
        int K = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());
            if (!book.isEmpty() && input == 0) {
                book.pop();
                continue;
            }
            book.push(input);
        }

        for (int i : book) {
            answer += i;
        }

        System.out.println(answer);
    }
}
