package programmers.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

class Programmers42583 {
    public static void main(String[] args) {
        System.out.println(solution2(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution2(100, 100, new int[]{10}));
        System.out.println(solution2(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {

        int finishTime = 0;
        int currentWeight = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int truck : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.add(truck);
                    currentWeight += truck;
                    finishTime++;
                    break;
                }

                if (queue.size() == bridge_length) {
                    currentWeight -= queue.poll();
                }

                if (currentWeight + truck <= weight) {
                    queue.add(truck);
                    currentWeight += truck;
                    finishTime++;
                    break;
                }

                queue.add(0);
                finishTime++;
            }
        }

        return finishTime + bridge_length;
    }

//    private static void logic(int truck, int bridge_length, int weight, Queue<Integer> queue) {
//        while (true) {
//            if (queue.isEmpty()) {
//                queue.add(truck);
//                currentWeight += truck;
//                finishTime++;
//                break;
//            }
//
//            if (queue.size() == bridge_length) {
//                currentWeight -= queue.poll();
//            }
//
//            if (currentWeight + truck <= weight) {
//                queue.add(truck);
//                currentWeight += truck;
//                finishTime++;
//                break;
//            }
//
//            queue.add(0);
//            finishTime++;
//        }
//    }

    static class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public static int solution2(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }
}
