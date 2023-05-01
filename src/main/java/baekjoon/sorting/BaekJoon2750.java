package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BaekJoon2750 {
    public static int[] arr;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        int[] ints = Arrays.stream(arr).sorted().toArray();

        for (int i : ints) {
            bw.write(i+"\n");
        }

        bw.flush();
        bw.close();
    }

    private static void merger_sort(int s, int e) {

    }
}
