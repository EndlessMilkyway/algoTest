package baekjoon.quicksort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11004 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(arr, 0, n - 1, k - 1);
        System.out.println(arr[k - 1]);
    }

    // 퀵 정렬 메서드
    private static void quickSort(int[] arr, int start, int end, int k) {
        if (start < end) {
            // 피벗 구하는 메서드 partition 호출
            int pivot = partition(arr, start, end);
            if (pivot == k) {                               // K번째 수가 pivot이면 더 이상 구할 필요가 없음
                return;
            } else if (pivot > k) {                         // K가 pivot보다 작으면 왼쪽 그룹만 정렬 수행
                quickSort(arr, start, pivot - 1, k);
            } else {                                        // K가 pivot보다 크면 오른쪽 그룹만 정렬 수행
                quickSort(arr, pivot + 1, end, k);
            }
        }
    }

    // 피벗 구하는 메서드
    private static int partition(int[] arr, int start, int end) {
        // 데이터가 2개인 경우에는 바로 비교하여 정렬
        if (start + 1 == end) {
            if (arr[start] > arr[end]) {
                swap(arr, start, end);
            }
            return end;
        }
        // 중앙값 계산
        int mid = (start + end) / 2;
        // 중앙값을 시작 위치와 swap
        swap(arr, start, mid);
        // pivot을 시작 위치 값으로 저장 - 위에서 swap 했으니까
        int pivot = arr[start];
        // 시작점 종료점 선언
        int i = start + 1, j = end;
        while (i <= j) {
            // 피벗보다 작은 수가 나올 때까지 j--
            while (pivot < arr[j] && j >= start + 1) {
                j--;
            }
            // 피벗보다 큰 수가 나올 때까지 i++
            while (pivot > arr[i] && i <= end) {
                i++;
            }
            // 찾은 i와 j를 swap
            if (i < j) {
                swap(arr, i++, j--);
            } else break;
        }
        // pivot 데이터를 나눠진 두 그룹의 경계 index에 저장
        arr[start] = arr[j];
        arr[j] = pivot;
        // 경계 index 반환
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
