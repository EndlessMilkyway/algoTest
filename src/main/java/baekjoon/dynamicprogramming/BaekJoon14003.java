package baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon14003 {
    static int N, maxLength;
    static int[] B = new int[1000001];
    static int[] A = new int[1000001];
    static int[] D = new int[1000001];
    static int[] ans = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int index;
        B[++maxLength] = A[1];
        D[1] = 1;
        for (int i = 2; i <= N; i++) {
            if (B[maxLength] < A[i]) { //가장 마지막 수열보다 현재 수열이 큰 경우
                B[++maxLength] = A[i];
                D[i] = maxLength;
            } else {
                index = binarySearch(1, maxLength, A[i]);    // B배열에서 data[i]보다 처음으로 크거나 같아지는 원소의 index 찾기
                B[index] = A[i];
                D[i] = index;
            }
        }
        System.out.println(maxLength); //가장 긴 증가하는 부분 수열 길이 출력
        index = maxLength;
        int x = B[maxLength] + 1;
        for (int i = N; i >= 1; i--) { //뒤에서 부터 탐색하면서 정답 수열 저장하기
            if (D[i] == index && A[i] < x) {
                ans[index] = A[i];
                x = A[i];
                index--;
            }
        }
        for (int i = 1; i <= maxLength; i++)
            System.out.print(ans[i] + " ");
    }

    // 현재 수열이 들어 갈 수 있는 위치를 빠르게 찾아주기 위한 바이너리 서치 구현
    static int binarySearch(int l, int r, int now) {
        int mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (B[mid] < now)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    /*
    public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Int(br.readLine()), last = 1, idx = 0, max = 0;
		int[] arr = new int[n + 1], dp = new int[n + 1], input = new int[n];
		Arrays.fill(arr, 1 << 30);
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int m = Int(st.nextToken());
			input[idx] = m;
			if (arr[last - 1] < m) {
				max = Math.max(max, dp[idx] = last);
				arr[last++] = m;
			} else {
				int l = 0, r = last;
				while(l < r) {
					int mid = (l + r) / 2;
					if (arr[mid] < m) l = mid + 1;
					else r = mid;
				}
				arr[r] = m;
				max = Math.max(max, dp[idx] = r);
			}
			idx++;
		}
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		for(int i = n - 1, d = last - 1; i >= 0; i--) {
			if (dp[i] == d) {
				list.add(input[i]);
				d--;
			}
		}
		list.sort(null);
		sb.append(list.size() + "\n");
		for(int i : list) sb.append(i + " ");
		System.out.print(sb);
	}
     */
}
