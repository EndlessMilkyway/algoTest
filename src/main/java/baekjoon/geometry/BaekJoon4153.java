package baekjoon.geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class BaekJoon4153 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            String input = br.readLine();
            if (Objects.equals(input, "0 0 0")) {
                break;
            }

            st = new StringTokenizer(input);
            String result = logic(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static String logic(int input1, int input2, int input3) {
        int maxVal = input1;
        int val1 = input2;
        int val2 = input3;

        if (input2 > maxVal && input2 > input3) {
            maxVal = input2;
            val1 = input1;
        } else if (input3 > maxVal && input3 > input2) {
            maxVal = input3;
            val2 = input1;
        }

        return maxVal * maxVal == val1 * val1 + val2 * val2 ? "right" : "wrong";
    }
}
