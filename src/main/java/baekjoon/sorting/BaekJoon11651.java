package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(points);

        System.out.println(output(points));
    }

    private static StringBuilder output(Point[] points) {
        StringBuilder sb = new StringBuilder();

        for (Point p : points) {
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
            if (this.y == o.y) {
                return this.x - o.x;
            }

            return this.y - o.y;
        }
    }
}
