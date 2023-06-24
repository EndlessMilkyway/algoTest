package baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon1463 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        /*
          Bottom-Top
          점화식 도출
          D[i] = D[i - 1] + 1
          if (i % 2 == 0) D[i] = Math.min(D[i], D[i / 2] + 1)
          if (i % 2 == 0) D[i] = Math.min(D[i], D[i / 2] + 1)
         */
        int[] D = new int[X + 1];
        D[1] = 0;
        for (int i = 2; i <= X; i++) {
            D[i] = D[i - 1] + 1;
            if (i % 2 == 0) D[i] = Math.min(D[i], D[i / 2] + 1);
            if (i % 3 == 0) D[i] = Math.min(D[i], D[i / 3] + 1);
        }
        System.out.println(D[X]);
    }
}
