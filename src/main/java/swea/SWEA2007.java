package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SWEA2007 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int pt;
        List<Character> list;

        for (int testCase = 1; testCase <= T; testCase++) {
            String s = br.readLine();
            pt = 0;
            list = new ArrayList<>();

            while (true) {
                char c = s.charAt(pt);
                if (list.contains(c)) {
                    int i = list.indexOf(c);
                    if (list.get(i + 1) == s.charAt(pt + 1) && list.get(i + 2) == s.charAt(pt + 2)) {
                        break;
                    }
                }

                list.add(c);
                pt++;
            }

            sb.append("#").append(testCase).append(" ").append(list.size()).append("\n");
        }
        System.out.println(sb);
    }
}
