package baekjoon.unionfind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon1043 {
    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int result = 0;
        // 진실을 알고 있는 사람 목록 저장
        int[] knownTrueP = new int[T];
        for (int i = 0; i < T; i++) {
            knownTrueP[i] = Integer.parseInt(st.nextToken());
        }
        // 파티 데이터 저장
        List<List<Integer>> partyList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            partyList.add(new ArrayList<>());
            int partySize = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partySize; j++) {
                partyList.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
        // 대표 노드 초기화
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        // 각 파티에 참여한 사람들을 1개의 그룹으로 만들기
        for (int i = 0; i < M; i++) {
            int firstP = partyList.get(i).get(0);
            for (int j = 1; j < partyList.get(i).size(); j++) {
                union(firstP, partyList.get(i).get(j));
            }
        }
        // 각 파티의 대표 노드와 진실을 아는 사람들의 대표 노드가 같다면 과장할 수 없음
        for (int i = 0; i < M; i++) {
            boolean canIdoLying = true;
            int cur = partyList.get(i).get(0);
            for (int k : knownTrueP) {
                if (find(cur) == find(k)) {
                    canIdoLying = false;
                    break;
                }
            }
            if (canIdoLying) result++;
        }
        System.out.println(result);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    private static int find(int a) {
        if (a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
}
