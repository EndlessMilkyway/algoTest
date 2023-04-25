package programmers.stackAndQueue;

import java.util.Stack;

public class Programmers12909 {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
        System.out.println(solution("())(()"));
        System.out.println(solution2("()()"));
        System.out.println(solution2("(())()"));
        System.out.println(solution2(")()("));
        System.out.println(solution2("(()("));
        System.out.println(solution2("())(()"));
    }

    private static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.length() % 2 == 1) { return false; }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i == 0 && c == ')') { return false; }

            if (c == '(') {
                stack.push(c);
            }

            if (c != '(' && !stack.empty()) {
                stack.pop();
            }
        }

        if (stack.size() > 0) {
            return false;
        }

        return true;

    }

    private static boolean solution2(String s) {
        int cnt = 0;

        if (s.length() % 2 == 1) { return false; }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '('){
                cnt++;
            }
            if(c == ')'){
                cnt--;
            }
            if(cnt < 0){
                break;
            }
        }

        return cnt == 0;
    }
}
