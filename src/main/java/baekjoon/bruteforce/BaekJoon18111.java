package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Info info = input(br);
        MapInfo mapInfo = generateMap(br, info);
        int[] answers = logic(mapInfo, info);

        System.out.println(answers[0] + " " + answers[1]);
    }

    private static Info input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        return new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
    }

    private static MapInfo generateMap(BufferedReader br, Info info) throws IOException {
        int[][] map = new int[info.n][info.m];
        int max = 0;
        int min = 256;
        StringTokenizer st;
        for (int i = 0; i < info.n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < info.m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > max) {
                    max = map[i][j];
                }
                if (map[i][j] < min) {
                    min = map[i][j];
                }
            }
        }

        return new MapInfo(map, max, min);
    }

    private static int[] logic(MapInfo mapInfo, Info info) {
        int timeTaken = 1000000000;
        int finalHeight = 0;

        for (int height = mapInfo.min; height <= mapInfo.max; height++) {
            int delCount = 0;
            int insCount = 0;
            int blockCount = info.b;

            for (int i = 0; i < info.n; i++) {
                for (int j = 0; j < info.m; j++) {
                    if (mapInfo.map[i][j] < height) {
                        insCount += height - mapInfo.map[i][j];
                        blockCount -= height - mapInfo.map[i][j];
                    }
                    if (mapInfo.map[i][j] > height) {
                        delCount += mapInfo.map[i][j] - height;
                        blockCount += mapInfo.map[i][j] - height;
                    }
                }
            }
            if (blockCount < 0) {
                continue;
            }
            int time = delCount * 2 + insCount;
            if (time <= timeTaken && height >= finalHeight) {
                timeTaken = time;
                finalHeight = height;
            }
        }

        return new int[] {timeTaken, finalHeight};
    }

    static class Info {
        int m;
        int n;
        int b;

        public Info(int n, int m, int b) {
            this.m = m;
            this.n = n;
            this.b = b;
        }
    }

    static class MapInfo {
        int[][] map;
        int max;
        int min;

        public MapInfo(int[][] map, int max, int min) {
            this.map = map;
            this.max = max;
            this.min = min;
        }
    }
}
