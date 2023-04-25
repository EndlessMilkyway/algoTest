package programmers.stackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers42586 {
    private static final int PROGRESS_DONE = 100;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{93,30,55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(solution(new int[]{95,70,80}, new int[]{1, 10, 5})));
        System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
//        System.out.println(Arrays.toString(solution2(new int[]{93,30,55}, new int[]{1, 30, 5})));
//        System.out.println(Arrays.toString(solution2(new int[]{95,70,80}, new int[]{1, 10, 5})));
//        System.out.println(Arrays.toString(solution2(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }

    private static int[] solution(int[] progresses, int[] speeds) {

        int cnt = 0;
        int lastBiggestVal = 999999999;
        List<Integer> answer = new ArrayList<>();
        List<Integer> remainDays = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            if ((PROGRESS_DONE - progresses[i]) % speeds[i] > 0) {
                remainDays.add((PROGRESS_DONE - progresses[i]) / speeds[i] + 1);
                continue;
            }
            remainDays.add((PROGRESS_DONE - progresses[i]) / speeds[i]);
        }

        for (int j = 0; j < remainDays.size(); j++) {
            if (j == 0) {
                lastBiggestVal = remainDays.get(j);
                cnt++;
                continue;
            }

            if (remainDays.get(j) > lastBiggestVal) {
                answer.add(cnt);
                lastBiggestVal = remainDays.get(j);
                cnt = 0;
            }

            cnt++;

            if (j == remainDays.size() - 1) {
                answer.add(cnt);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static int[] solution2(int[] progresses, int[] speeds) {

        int[] datOfEnd = new int[100];
        int day = -1;
        for(int i = 0; i < progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            datOfEnd[day]++;
        }

        return Arrays.stream(datOfEnd).filter(i -> i!=0).toArray();
    }
}
