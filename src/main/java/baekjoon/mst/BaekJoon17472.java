package baekjoon.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon17472 {
    /**
     * dr, dc : 4방향 탐색을 위한 상수
     * N, M : 행렬의 크기
     * iNum : 각 섬들의 번호를 붙이기 위한 정수형 변수
     * map : 맵 정보 저장 배열
     * parent : 대표 노드 저장 배열
     * visited : BFS를 할 때 방문 여부 저장 배열
     * sumList : 모든 섬 정보 저장하기
     * mList : 1개의 섬 정보 저장하기
     * queue : 다리 정보를 저장할 우선순위 큐
     */
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};
    private static int N, M, iNum;
    private static int[][] map;
    private static int[] parent;
    private static boolean[][] visited;
    private static List<List<int[]>> sumList;
    private static List<int[]> mList;
    private static PriorityQueue<Edge> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();
        // 맵 정보 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // BFS 탐색으로 섬들을 구분
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    bfs(i, j);
                    iNum++;
                    sumList.add(mList);
                }
            }
        }
        findEdge();
        System.out.println(kruskal());
    }

    private static void init() {
        map = new int[N][M];
        visited = new boolean[N][M];
        iNum = 1;
        sumList = new ArrayList<>();
    }

    // union 연산
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    // find 연산
    private static int find(int a) {
        if (a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }

    // BFS를 이용해 연결된 섬 찾기
    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        mList = new ArrayList<>();
        int[] start = {i, j};
        map[i][j] = iNum;
        visited[i][j] = true;
        mList.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            // 네 방향 검색하기
            for (int d = 0; d < 4; d++) {
                int tmpR = dr[d];
                int tmpC = dc[d];
                while (r + tmpR >= 0 && r + tmpR < N && c + tmpC >= 0 && c + tmpC < M) {
                    // 지금까지 방문한 적이 없고 바다가 아니면 같은 섬으로 취급
                    if (!visited[r + tmpR][c + tmpC] && map[r + tmpR][c + tmpC] != 0)
                        addNode(r + tmpR, c + tmpC, queue);
                    else
                        break;
                    if (tmpR < 0) tmpR--;
                    else if (tmpR > 0) tmpR++;
                    else if (tmpC < 0) tmpC--;
                    else if (tmpC > 0) tmpC++;
                }
            }
        }
    }

    // 특정 위치를 섬의 정보로 넣어 주는 함수
    private static void addNode(int i, int j, Queue<int[]> queue) {
        int[] tmp = {i, j};
        map[i][j] = iNum;
        visited[i][j] = true;
        mList.add(tmp);
        queue.add(tmp);
    }

    // 섬의 각 지점에서 만들 수 있는 모든 에지를 저장하는 함수
    private static void findEdge() {
        queue = new PriorityQueue<>();
        for (List<int[]> current : sumList) {
            for (int[] ints : current) {
                int r = ints[0];
                int c = ints[1];
                int currentIsland = map[r][c];
                for (int d = 0; d < 4; d++) {
                    int tmpR = dr[d];
                    int tmpC = dc[d];
                    int bridgeLength = 0;
                    while (r + tmpR >= 0 && r + tmpR < N && c + tmpC >= 0 && c + tmpC < M) {
                        // 같은 섬이면 에지를 만들 수 없음
                        if (map[r + tmpR][c + tmpC] == currentIsland) {
                            break;
                        } else if (map[r + tmpR][c + tmpC] != 0) { // 같은 섬도 아니고 바다도 아니면
                            // 다른 섬으로 가는 다리가 길이가 1 이상일 경우에만 에지로 더하기
                            if (bridgeLength > 1)
                                queue.add(new Edge(currentIsland, map[r + tmpR][c + tmpC], bridgeLength));
                            break;
                        } else {
                            bridgeLength++;
                        }
                        if (tmpR < 0)
                            tmpR--;
                        else if (tmpR > 0)
                            tmpR++;
                        else if (tmpC < 0)
                            tmpC--;
                        else if (tmpC > 0)
                            tmpC++;
                    }
                }
            }
        }
    }

    private static int kruskal() {
        parent = new int[iNum];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int useEdge = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
        }

        if (useEdge == iNum - 2) return result;
        else return -1;
    }

    static class Edge implements Comparable<Edge> {
        int s, e, v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return this.v - o.v;
        }
    }
}
