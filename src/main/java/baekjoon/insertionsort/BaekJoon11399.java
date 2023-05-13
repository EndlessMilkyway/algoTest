package baekjoon.insertionsort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11399 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sumArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            int insertIdx = i;
            int insertVal = arr[i];
            // 현재 범위에서 삽입 위치 찾기
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    insertIdx = j + 1;
                    break;
                }
                if (j == 0) {
                    insertIdx = 0;
                }
            }
            // 삽입을 위해 삽입 위치에서 i까지 데이터를 한 칸씩 뒤로 밀기
            for (int j = i; j > insertIdx; j--) {
                arr[j] = arr[j - 1];
            }
            // 삽입 위치에 현재 데이터 삽입하기
            arr[insertIdx] = insertVal;
        }

        sumArr[0] = arr[0];
        // A 배열을 통해 합 배열 S 만들기
        for (int i = 1; i < n; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sumArr[i];
        }
        System.out.println(sum);
    }
}
