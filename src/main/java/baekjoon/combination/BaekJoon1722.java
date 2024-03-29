package baekjoon.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());

        long[] factArr = new long[N + 1];
        int[] result = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        factArr[0] = 1;
        for (int i = 1; i <= N; i++) // 팩토리얼 초기화 -> 각 자리수에서 만들수 있는 경우의 수
            factArr[i] = factArr[i - 1] * i;

        st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());

        if (Q == 1) {
            long K = Long.parseLong(st.nextToken());
            for (int i = 1; i <= N; i++) {
                for (int j = 1, cnt = 1; j <= N; j++) {
                    if (visit[j])
                        continue; // 이미 사용한 숫자는 사용할 수 없음
                    if (K <= cnt * factArr[N - i]) { // 주어진 K에 따라 각 자리에 들어갈 수 있는 수 찾기
                        K -= ((cnt - 1) * factArr[N - i]);
                        result[i] = j;
                        visit[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for (int i = 1; i <= N; i++)
                sb.append(result[i]).append(" ");
        } else {
            long K = 1;
            for (int i = 1; i <= N; i++) {
                result[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for (int j = 1; j < result[i]; j++)
                    if (!visit[j])
                        cnt++; // 미사용 숫자 개수만큼 카운트
                K += cnt * factArr[N - i]; // 자리수 개수에 따라 순서 더해주기
                visit[result[i]] = true;
            }
            sb.append(K);
        }
        System.out.println(sb);
    }
}
