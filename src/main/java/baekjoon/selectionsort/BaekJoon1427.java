package baekjoon.selectionsort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon1427 {
    public static void main(String[] args) throws Exception {
        String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Integer.parseInt(s.substring(i, i + 1));
        }
        for (int i = 0; i < s.length(); i++) {
            int maxIdx = i;
            for (int j = i + 1; j < s.length(); j++) {
                // 현재 범위에서 max값 찾기
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            // 현재 i의 값과 max값 중 max값이 더 크면 swap 수행
            if (arr[i] < arr[maxIdx]) {
                int tmp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = tmp;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}
