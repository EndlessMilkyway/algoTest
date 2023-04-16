package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 팔씨름
public class SWEA_13547 {
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= T; testCase++)
        {
            String S = br.readLine();
            int winCount = 0;
            int loseCount = 0;

            for (char a : S.toCharArray()) {
                if (String.valueOf(a).equals("o")) {
                    winCount += 1;
                }
                loseCount += 1;
            }

            bw.write("#" + testCase + " " + judge(winCount, loseCount, S.length()));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static String judge(int winCount, int loseCount, int length) {
        if (winCount > 7 || 15 - length >= 8 - winCount) {
            return "YES";
        }
        return "NO";
    }
}
