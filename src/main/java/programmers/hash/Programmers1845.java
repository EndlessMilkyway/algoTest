package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Programmers1845 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,3,3,2,2,2}));
    }
    public static int solution(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int type : nums) {
            if (map.containsKey(type)) {
                map.replace(type, map.get(type) + 1);
            }

            if (!map.containsKey(type)) {
                map.put(type, 1);
            }
        }

        return Math.min(map.size(), n/2);
    }

}
