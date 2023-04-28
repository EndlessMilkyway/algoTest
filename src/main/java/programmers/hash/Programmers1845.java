package programmers.hash;

import java.util.HashMap;
import java.util.Map;

/*
폰켓몬 (https://school.programmers.co.kr/learn/courses/30/lessons/1845)
 */
public class Programmers1845 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2,3}));
        System.out.println(solution(new int[]{3,3,3,2,2,4}));
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
