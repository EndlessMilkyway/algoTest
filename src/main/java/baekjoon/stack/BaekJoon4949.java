package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class BaekJoon4949 {
    public static void main(String[] args) throws IOException {
        System.out.println(logic(input()));
    }

    private static List<String> input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputs = new ArrayList<>();

        while (true) {
            String input = br.readLine();
            if (Objects.equals(input, ".")) {
                break;
            }
            inputs.add(input);
        }

        return inputs;
    }

    private static StringBuilder logic(List<String> inputs) {
        StringBuilder sb = new StringBuilder();

        for (String input : inputs) {
            sb.append(checkValance(input)).append("\n");
        }

        return sb;
    }

    private static String checkValance(String input) {
        Stack<Character> stack = new Stack<>();
        char[] chars = input.replaceAll("[^\\[\\]\\(\\)]", "").toCharArray();
        int cnt = 0;

        for (char c : chars) {
            if (c == '(' || c == '[') {
                stack.push(c);
                cnt++;
                continue;
            }
            if (c == ')' || c == ']') {
                cnt--;
            }
            if (!stack.isEmpty() && (c == ')' && stack.peek() == '(') || !stack.isEmpty() && (c == ']'
                    && stack.peek() == '[')) {
                stack.pop();
            }
        }

        return stack.isEmpty() && cnt == 0 ? "yes" : "no";
    }
}
