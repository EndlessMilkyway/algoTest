package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("-");
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = calculatingFormula(arr[i]);
            if (i == 0)
                answer += tmp;
            else
                answer -= tmp;
        }
        System.out.println(answer);
    }

    private static int calculatingFormula(String s) {
        int sum = 0;
        String[] tmp = s.split("[+]");
        for (String value : tmp)
            sum += Integer.parseInt(value);
        return sum;
    }
}

