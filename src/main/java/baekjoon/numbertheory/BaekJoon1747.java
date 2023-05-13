package baekjoon.numbertheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon1747 {
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int[] arr = new int[10000001];
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j < arr.length; j = j + i) {
                arr[j] = 0;
            }
        }
        int i = n;
        while (true) {
            if (arr[i] != 0) {
                int result = arr[i];
                if (isPalindrome(result)) {
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }

    private static boolean isPalindrome(int target) {
        char[] tmp = String.valueOf(target).toCharArray();
        int s = 0;
        int e = tmp.length - 1;
        while (s < e) {
            if (tmp[s] != tmp[e]) return false;
            s++;
            e--;
        }
        return true;
    }
}
