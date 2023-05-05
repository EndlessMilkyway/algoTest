package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon1436 {
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int cnt = 0;
        int title = 666;

        while (true) {
            String tmp = String.valueOf(title);
            if (tmp.contains("666")) {
                cnt++;
                if (cnt == n) {
                    System.out.println(title);
                    break;
                }
            }
            title++;
        }
    }
}
