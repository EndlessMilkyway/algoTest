package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2231 {
    public static void main(String[] args) throws IOException {
        System.out.println(logic(input()));
    }

    private static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    private static int logic(int N) {
        int checkVal = N - countDigits(N) * 9;
        while (checkVal + sumOfDigits(checkVal) != N) {
            if (checkVal == N - 1) {
                return 0;
            }
            checkVal++;
        }

        return checkVal;
    }

    private static int countDigits(int num) {
        int cnt = 0;
        while (num != 0) {
            num /= 10;
            cnt++;
        }
        return cnt;
    }

    private static int sumOfDigits(int num) {
        int answer = 0;
        while (num != 0) {
            answer += num % 10;
            num /= 10;
        }
        return answer;
    }
}
