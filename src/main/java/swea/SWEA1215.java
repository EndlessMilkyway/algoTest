package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1215 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[][] board;

        for (int testCase = 1; testCase <= 10; testCase++) {
            int length = Integer.parseInt(br.readLine());
            board = new char[8][8];

            for (int i = 0; i < 8; i++)
                board[i] = br.readLine().toCharArray();

            sb.append("#").append(testCase).append(" ").append(findPalindrome(board, length)).append("\n");
        }
        System.out.println(sb);
    }

    private static int findPalindrome(char[][] arr, int length) {
        int result = 0;

        for (int i = 0; i < 8; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < 8; j++) {
                sb.append(arr[i][j]);
                if (sb.length() > length)
                    sb.delete(0, 1);
                if (sb.length() == length && palindrome(sb))
                    result++;
            }
        }

        for (int j = 0; j < 8; j++) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 8; i++) {
                sb.append(arr[i][j]);
                if (sb.length() > length)
                    sb.delete(0, 1);
                if (sb.length() == length && palindrome(sb))
                    result++;

            }
        }

        return result;
    }

    private static boolean palindrome(StringBuffer sb) {
        String str1 = sb.toString();
        String str2 = sb.reverse().toString();
        sb.reverse();
        return str1.equals(str2);
    }
}
