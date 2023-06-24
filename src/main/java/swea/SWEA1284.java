package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1284 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int P, Q, R, S, W;
        int priceA, priceB;

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            P = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            priceA = W * P;
            priceB = Q;

            if (W > R) {
                priceB += (W - R) * S;
            }

            sb.append("#").append(testCase).append(" ").append(Math.min(priceA, priceB)).append("\n");
        }
        System.out.println(sb);
    }
}
