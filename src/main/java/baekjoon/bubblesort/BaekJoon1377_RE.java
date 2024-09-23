package baekjoon.bubblesort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BaekJoon1377_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Data[] arr = new Data[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Data(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o.val));

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < arr[i].idx - i) {
                max = arr[i].idx - i;
            }
        }
        System.out.println(max + 1);
    }

    static class Data {
        int idx;
        int val;

        public Data(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
