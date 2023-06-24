package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1240 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] boxes;
        int maxIdx, minIdx, maxVal, minVal;

        for (int testCase = 1; testCase <= 10; testCase++) {
            int dumps = Integer.parseInt(br.readLine());
            boxes = new int[100];
            maxIdx = 1000;
            minIdx = 1000;
            minVal = 101;
            maxVal = -1;

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 100; i++) {
                boxes[i] = Integer.parseInt(st.nextToken());
            }

            while (dumps != 0) {
                for (int i = 0; i < 100; i++) {
                    if (boxes[i] < minVal) {
                        minIdx = i;
                        minVal = boxes[i];
                    }

                    if (boxes[i] > maxVal) {
                        maxIdx = i;
                        maxVal = boxes[i];
                    }
                }

                boxes[minIdx] += 1;
                boxes[maxIdx] -= 1;
                maxIdx = 1000;
                minIdx = 1000;
                minVal = 101;
                maxVal = -1;

                dumps--;
            }

            for (int i = 0; i < 100; i++) {
                if (boxes[i] < minVal) {
                    minVal = boxes[i];
                }

                if (boxes[i] > maxVal) {
                    maxVal = boxes[i];
                }
            }

            sb.append("#").append(testCase).append(" ").append(maxVal - minVal).append("\n");
        }
        System.out.println(sb);
    }
}
