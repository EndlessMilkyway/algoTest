package programmers.stackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers12906 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(solution(new int[]{4, 4, 4, 3, 3})));
    }

    private static int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        for (int i : arr) {
            if (answer.size() == 0) {
                answer.add(i);
                continue;
            }

            if (answer.get(answer.size() - 1) == i) {
                continue;
            }

            answer.add(i);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
