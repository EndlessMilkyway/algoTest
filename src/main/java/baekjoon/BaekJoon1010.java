package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 1010번 다리놓기
 * BigInteger 사용
 */
public class BaekJoon1010 {

    static List<BigInteger> dpList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        // init bufferReader and lists
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> sitesStoreList = new ArrayList<>();
        List<BigInteger> result = new ArrayList<>();

        int maxVal = 0;

        // receive test case count from user
        int testCaseCount = Integer.parseInt(br.readLine());

        // store number to Two-Dimension List
        for (int i = 0; i < testCaseCount; i++) {
            List<Integer> sites = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            sites.add(Integer.parseInt(st.nextToken()));
            sites.add(Integer.parseInt(st.nextToken()));

            sitesStoreList.add(sites);
        }

        // calculate maximum value in inputs
        for (List<Integer> list : sitesStoreList) {
            if (list.get(1) > list.get(0) && list.get(1) > maxVal) {
                maxVal = list.get(1);
            }
            if (list.get(0) > maxVal) {
                maxVal = list.get(0);
            }
        }

        // init dpList
        for (int i = 0; i < maxVal + 1; i++) {
            dpList.add(i , BigInteger.ZERO);
        }

        // close BufferReader
        br.close();

        // calculate result and save that in list
        for (List<Integer> list : sitesStoreList) {
            int m = list.get(1);
            int n = list.get(0);

            result.add(fact(m).divide(fact(n).multiply(fact(m - n))));
        }

        // Print algorithm result
        for (BigInteger item : result) {
            System.out.println(item);
        }
    }

    private static BigInteger fact(int number) {

        if (dpList.get(number).compareTo(BigInteger.ZERO) > 0) {
            return dpList.get(number);
        }

        if (number == 1 || number == 0) {
            dpList.set(number, BigInteger.ONE);
            return dpList.get(number);
        }

        dpList.set(number, fact(number - 1).multiply(new BigInteger(String.valueOf(number))));
        return dpList.get(number);
    }
}
