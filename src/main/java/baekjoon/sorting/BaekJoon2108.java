package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public class BaekJoon2108 {
    public static void main(String[] args) throws IOException {
        System.out.println(output(input()));
    }

    private static int[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        return nums;
    }

    private static StringBuilder output(int[] nums) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(nums);
        sb.append(calcMean(nums)).append("\n");
        sb.append(calcMedian(nums)).append("\n");
        sb.append(calcMode(nums)).append("\n");
        sb.append(calcRange(nums)).append("\n");

        return sb;
    }

    private static int calcMean(int[] nums) {
        return Math.toIntExact(Math.round(Arrays.stream(nums).average().getAsDouble()));
    }

    private static int calcMedian(int[] nums) {
        int center = nums.length / 2;

        if (nums.length % 2 == 0) {
            return (nums[center - 1] + nums[center]) / 2;
        } else {
            return nums[center];
        }
    }

    private static Map<Integer, Integer> makeMap(int[] nums) {
        Map<Integer, Integer> frequency = new TreeMap<>();
        for (int i : nums) {
            if (frequency.containsKey(i)) {
                frequency.replace(i, frequency.get(i) + 1);
                continue;
            }
            frequency.put(i, 1);
        }

        return frequency;
    }

    private static int calcMode(int[] nums) {
        Entry<Integer, Integer> maxEntry = null;
        Map<Integer, Integer> frequency = makeMap(nums);
        Integer maxVal = frequency.values().stream().max(Comparator.comparingInt(Integer::intValue)).get();
        Set<Entry<Integer, Integer>> entrySet = frequency.entrySet();
        for (Entry<Integer, Integer> entry : entrySet) {
            if (maxEntry == null || entry.getValue() >= maxEntry.getValue()) {
                if (entry.getValue() < maxVal) {
                    continue;
                }
                if (maxEntry != null && Objects.equals(maxEntry.getValue(), entry.getValue())
                        && maxEntry.getKey() < entry.getKey()) {
                    maxEntry = entry;
                    break;
                }
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();
    }

    private static int calcRange(int[] nums) {
        return nums[nums.length - 1] - nums[0];
    }
}
