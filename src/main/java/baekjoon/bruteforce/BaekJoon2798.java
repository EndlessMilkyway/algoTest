package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2798 {
    private static int N, M, sum, cnt, answer;
    private static int[] cards;
    private static boolean[] checked;
    public static void main(String[] args) throws IOException {
        initAndInput();
        for (int i = 0; i < N - (3 - (cnt + 1)); i++) {
            logic(i);
        }
        System.out.println(answer);
    }

    private static void initAndInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sum = 0;
        cards = new int[N];
        checked = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++)
            cards[i] = Integer.parseInt(st.nextToken());
    }

    private static void logic(int idx) {
        if (!checked[idx]) {
            cnt++;
            sum += cards[idx];
            checked[idx] = true;
        }

        if (cnt == 3) {
            if (sum <= M && sum > answer) {
                answer = sum;
            }
        } else {
            for (int i = idx + 1; i < N - (3 - (cnt + 1)); i++) {
                logic(i);
            }
            for (int i = idx + 1; i < N; i++) {
                checked[i] = false;
            }
        }
        sum -= cards[idx];
        cnt--;
    }
}
