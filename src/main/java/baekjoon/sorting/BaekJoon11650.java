package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon11650 {
    private static int N;
    private static List<Point> list;

    public static void main(String[] args) throws IOException {
        list = new ArrayList<>();
        input();
        Collections.sort(list);
        System.out.println(output());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    private static StringBuilder output() {
        StringBuilder sb = new StringBuilder();

        for (Point p : list) {
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }

        return sb;
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x > o.x) {
                return 1;
            } else if (this.x == o.x) {
                return Integer.compare(this.y, o.y);
            }
            return -1;
        }
    }

}
