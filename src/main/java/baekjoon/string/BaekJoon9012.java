package baekjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            sb.append(logic(input)).append("\n");
        }

        System.out.println(sb);
    }

    private static String logic(String input) {
        int cnt = 0;
        for (char c : input.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (cnt == 0) {
                return "NO";
            } else {
                cnt--;
            }
        }

        return cnt == 0 ? "YES" : "NO";
    }
}
