package baekjoon.selectionsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1427_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        br.close();

        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Integer.parseInt(s.substring(i, i + 1));
        }

        for (int i = 0; i < arr.length; i++) {
            int max = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            if (arr[i] < arr[max]) {
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }
        for (int num : arr) {
            System.out.print(num);
        }
    }
}
