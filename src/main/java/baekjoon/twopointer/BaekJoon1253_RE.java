package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1253_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }
        br.close();
        Arrays.sort(nums);

        System.out.println(findGoodNumCase(n, nums));
    }

    private static int findGoodNumCase(int n, long[] nums) {
        int result = 0;

        for (int k = 0; k < n; k++) {
            long find = nums[k];
            int i = 0;
            int j = n - 1;
            // 투 포인터 알고리즘
            while (i < j) {
                if (nums[i] + nums[j] == find) {
                    // find는 서로 다른 두 수의 합이어야 함을 체크
                    if (i != k && j != k) {
                        result++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else {
                        j--;
                    }
                } else if (nums[i] + nums[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        return result;
    }
}
