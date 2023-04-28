package baekjoon.arrayandlist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BaekJoon11720 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        br.close();

        int result = 0;

        for (int i = 0; i < n; i++) {
            result += arr[i] - 48;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
