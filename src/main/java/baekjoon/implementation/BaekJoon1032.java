package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1032 {
    static int N;
    static char[] answer, nameToCompare;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        answer = br.readLine().toCharArray();

        for (int i = 0; i < N - 1; i++) {
            nameToCompare = br.readLine().toCharArray();
            for (int j = 0; j < answer.length; j++) {
                if(answer[j] != nameToCompare[j]) {
                    answer[j] = '?';
                }
            }
        }
        System.out.println(answer);
    }
}
