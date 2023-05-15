package baekjoon.topologysort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1516 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        // 진입 차수 배열
        int[] degreeArr = new int[N + 1];
        // 건설 시간 배열
        int[] selfBuild = new int[N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            // 건설 시간 업데이트
            selfBuild[i] = Integer.parseInt(st.nextToken());
            // 인접 리스트 초기화
            while (true) {
                int input = Integer.parseInt(st.nextToken());
                if (input == -1) {
                    break;
                }
                list.get(input).add(i);
                // 진입 차수 배열 업데이트
                degreeArr[i]++;
            }
        }
        // 위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (degreeArr[i] == 0) {
                queue.offer(i);
            }
        }
        int[] result = new int[N + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : list.get(now)) {
                degreeArr[next]--;
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                if (degreeArr[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(result[i] + selfBuild[i]).append("\n");
        }
        System.out.println(sb);
    }
}
