package baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BaekJoon9252 {
    private static int[][] D;
    private static char[] input1;
    private static char[] input2;
    private static List<Character> lcs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        input1 = br.readLine().toCharArray();
        input2 = br.readLine().toCharArray();
        D = new int[input1.length + 1][input2.length + 1];
        lcs = new ArrayList<>();

        // 점화식 배열 생성
        for (int i = 1; i <= input1.length; i++) {
            for (int j = 1; j <= input2.length; j++) {
                if (input1[i - 1] == input2[j - 1])
                    D[i][j] = D[i - 1][j - 1] + 1;
                else
                    D[i][j] = Math.max(D[i - 1][j], D[i][j - 1]);
            }
        }

        sb.append(D[input1.length][input2.length]).append("\n");
        printLCS(input1.length, input2.length);
        for (int i = lcs.size() - 1; i >= 0; i--) {
            sb.append(lcs.get(i));
        }
        System.out.println(sb);
    }

    private static void printLCS(int r, int c) {
        if (r == 0 || c == 0) return;

        if (input1[r - 1] == input2[c - 1]) {   // 두 문자열이 같을 경우
            lcs.add(input1[r - 1]);
            printLCS(r - 1, c - 1);
        } else {                                // 두 문자열이 다를 경우
            if (D[r - 1][c] > D[r][c - 1])
                printLCS(r - 1, c);
            else
                printLCS(r, c - 1);
        }
    }
}
