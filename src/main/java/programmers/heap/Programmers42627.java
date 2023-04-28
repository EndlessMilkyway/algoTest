package programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Programmers42627 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
        System.out.println(solution(new int[][]{{5, 8}, {7, 2}, {11, 5}}));
    }

    public static int solution(int[][] jobs) {
        int sumOfTime = 0;
        int count = 0; // 처리 완료한 요청
        int finishTime = 0; // 요청이 완료된 시점
        int idx = 0; // 배열 인덱스

        // 매개변수로 전달 받은 배열 정렬 (기준: 요청 시간, 오름차순)
        Arrays.sort(jobs, Comparator.comparingInt(i -> i[0]));

        // 우선순위 큐 선언 및 생성 (기준: 소요 시간, 오름차순)
        Queue<int[]> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));

        while (count < jobs.length) {
            // 작업이 완료된 시점까지 들어온 요청들을 큐에 삽입
            while (idx < jobs.length && jobs[idx][0] <= finishTime) {
                queue.add(jobs[idx++]);
            }

            // 작업 완료 시점 갱신
            if (queue.isEmpty()) {
                finishTime = jobs[idx][0];
            } else {
                int[] temp = queue.poll();
                sumOfTime += temp[1] + finishTime - temp[0];
                finishTime += temp[1];
                count++;
            }

        }

        return (int) Math.floor(sumOfTime / jobs.length);
    }

}