package baekjoon.bubblesort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon1377 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        mData[] arr = new mData[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new mData(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(arr);
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            // arr[i]의 정렬 전 index - 정렬 후 index 계산의 최댓값을 찾아 저장
            if (maxVal < arr[i].idx - i) {
                maxVal = arr[i].idx - i;
            }
        }
        System.out.println(maxVal + 1);
    }

    static class mData implements Comparable<mData> {
        int idx;
        int value;

        public mData(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        // value 기준 오름차순 정렬 함수 Comparable 구현하기
        @Override
        public int compareTo(mData o) {
            return this.value - o.value;
        }
    }

}