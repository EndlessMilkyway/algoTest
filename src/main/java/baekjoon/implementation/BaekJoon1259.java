package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class BaekJoon1259 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String tmp;
        boolean flag = true;
        while (!Objects.equals(tmp = br.readLine(), "0")) {
            for (int i = 0; i < tmp.length() / 2; i++) {
                if (tmp.charAt(i) != tmp.charAt((tmp.length() - 1) - i)) {
                    sb.append("no\n");
                    flag = false;
                    break;
                }
            }
            if (flag) sb.append("yes\n");
            flag = true;
        }
        System.out.println(sb);
    }
}
