package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<Integer> queue;
        int minusVal;

        for (int testCase = 1; testCase <= 10; testCase++) {
            int uselessInput = Integer.parseInt(br.readLine());
            queue = new LinkedList<>();
            minusVal = 1;

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 8; i++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            while (true) {
                if (minusVal == 6) {
                    minusVal = 1;
                }
                int i = queue.poll().intValue();
                i -= minusVal;
                queue.add(Math.max(i, 0));
                minusVal++;
                if (i <= 0) {
                    break;
                }
            }

            sb.append("#").append(testCase).append(" ");

            while (!queue.isEmpty()) {
                sb.append(queue.poll()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
