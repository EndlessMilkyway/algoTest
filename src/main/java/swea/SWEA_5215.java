package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 햄버거 다이어트
public class SWEA_5215 {
    private static int[] score;
    private static int[] calorie;
    private static int n; // ingredients amount
    private static int l; // limit
    private static int output;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            score = new int[n];
            calorie = new int[n];
            output = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer a = new StringTokenizer(br.readLine(), " ");
                score[i] = Integer.parseInt(a.nextToken());
                calorie[i] = Integer.parseInt(a.nextToken());
            }

            logic(0, 0, 0);

            bw.write("#" + testCase + " " + output);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void logic(int idx, int scoreSum, int calorieSum) {

        if (calorieSum > l) {
            return;
        }
        if (idx == n) {
            if (scoreSum > output) {
                output = scoreSum;
            }
            return;
        }

        logic(idx + 1, scoreSum + score[idx], calorieSum + calorie[idx]);
        logic(idx + 1, scoreSum, calorieSum);
    }
}
