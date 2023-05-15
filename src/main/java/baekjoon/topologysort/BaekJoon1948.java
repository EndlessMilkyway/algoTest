package baekjoon.topologysort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1948 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<List<cNode>> list = new ArrayList<>();
        List<List<cNode>> reverseList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }
        int[] degreeArr = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            list.get(S).add(new cNode(E, V));
            reverseList.get(E).add(new cNode(S, V));
            degreeArr[E]++;
        }
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        // Topology Sort
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int[] result = new int[N + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (cNode next : list.get(now)) {
                degreeArr[next.targetNode]--;
                result[next.targetNode] = Math.max(result[next.targetNode], result[now] + next.takenTime);
                if (degreeArr[next.targetNode] == 0) {
                    queue.offer(next.targetNode);
                }
            }
        }

        // Reverse Topology Sort
        int resultCnt = 0;
        boolean[] visited = new boolean[N + 1];
        queue = new LinkedList<>();
        queue.offer(dest);
        visited[dest] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (cNode next : reverseList.get(now)) {
                // 1분도 쉬지않는 도로 체크하기
                if (result[next.targetNode] + next.takenTime == result[now]) {
                    resultCnt++;
                    // 중복 카운트를 제거하기 위해 이미 방문한 노드 제외하기
                    if (!visited[next.targetNode]) {
                        visited[next.targetNode] = true;
                        queue.offer(next.targetNode);
                    }
                }
            }
        }
        System.out.println(result[dest]);
        System.out.println(resultCnt);
    }

    static class cNode {
        int targetNode;
        int takenTime;

        public cNode(int targetNode, int takenTime) {
            this.targetNode = targetNode;
            this.takenTime = takenTime;
        }
    }

}
