package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 알파벳 공름
public class SWEA_15230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        char[] dict = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for(int testCase = 1; testCase <= T; testCase++)
        {
            char[] input = br.readLine().toCharArray();
            int cnt = 0;

            for (int i = 0; i < input.length; i++) {
                if (input[i] != dict[i]) break;
                cnt += 1;
            }

            bw.write("#" + testCase + " " + cnt);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
