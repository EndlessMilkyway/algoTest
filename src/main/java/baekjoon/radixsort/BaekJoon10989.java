package baekjoon.radixsort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon10989 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        radixSort(A, 5);
        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void radixSort(int[] A, int maxSize) {
        int[] output = new int[A.length];
        // 현재 자릿수 position = 1의 자리, 10의 자리 등을 계산, count = 반복문 횟수 계산
        int position = 1;
        int count = 0;
        while (count != maxSize) {
            // 현재 자릿수들의 분포를 합 배열의 형태로 알려 주는 배열
            int[] bucket = new int[10];
            // 현재 자릿수를 기준으로 배열 A의 데이터를 배열 bucket에 count
            for (int i = 0; i < A.length; i++) {
                bucket[(A[i] / position) % 10]++;
            }
            // 합 배열을 이용해 index 계산
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            // bucket값을 이용해 현재 자릿수를 기준으로 데이터를 정렬 후 output 배열에 저장
            for (int i = A.length - 1; i >= 0; i--) {
                output[bucket[(A[i] / position % 10)] - 1] = A[i];
                bucket[(A[i] / position) % 10]--;
            }
            // 다음 자릿수 이동을 위해 A 배열에 output 배열 데이터를 저장
            for (int i = 0; i < A.length; i++) {
                A[i] = output[i];
            }
            position *= 10;
            count++;
        }
    }
}
