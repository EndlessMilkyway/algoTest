package baekjoon.arrayandlist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BaekJoon1546 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int max = 0;
        int currentVal;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            currentVal = Integer.parseInt(st.nextToken());
            if (currentVal > max) max = currentVal;
            sum += currentVal;
        }

        bw.write((double) sum * 100 / max / n + "");
        bw.flush();
        bw.close();
    }
}
