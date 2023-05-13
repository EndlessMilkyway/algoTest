package baekjoon.eratosthenes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1016 {
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] check = new boolean[(int) (max - min + 1)];
        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long startIdx = min / pow;
            if (min % pow != 0)
                startIdx++;
            for (long j = startIdx; pow * j <= max; j++)
                check[(int) ((j * pow) - min)] = true;
        }
        int cnt = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!check[i])
                cnt++;
        }
        System.out.println(cnt);
    }
}
