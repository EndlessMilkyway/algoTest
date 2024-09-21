package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1940_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] materials = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(materials, 0, n - 1);
        br.close();
        System.out.println(manufacturingArmor(materials, n, m));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int i = start - 1;
        int j = end + 1;
        int pivot = arr[(start + end) / 2];
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot && i <= j);

            if (i >= j) {
                return j;
            }

            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int manufacturingArmor(int[] materials, int amount, int goal) {
        int availableCnt = 0;
        int i = 0;
        int j = amount - 1;

        while (i < j) {
            if (materials[i] + materials[j] < goal) {
                i++;
            } else if (materials[i] + materials[j] > goal) {
                j--;
            } else {
                availableCnt++;
                i++;
                j--;
            }
        }

        return availableCnt;
    }
}
