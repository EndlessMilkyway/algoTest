package programmers.stackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class Programmers42584 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 6, 1, 1, 2, 3, 1, 2, 3})));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 1})));
        System.out.println(Arrays.toString(solution(new int[]{5, 4, 3, 2, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3, 1})));
    }
    private static int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        Stack<Stock> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            Stock stock = new Stock(prices[i], i);

            if (stack.empty()) {
                stack.push(stock);
                continue;
            } else {
                while (stack.peek().price > prices[i]) {
                    answer[stack.peek().duration] = i - stack.peek().duration;
                    stack.pop();
                    if (stack.empty()) {
                        break;
                    }
                }
            }

            stack.push(stock);
        }

        while (!stack.empty()) {
            answer[stack.peek().duration] = prices.length - 1 - stack.peek().duration;
            stack.pop();
        }

        return answer;
    }

    public int[] solution2(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }
}

class Stock {
    int price;
    int duration;

    public Stock(int price, int duration) {
        this.price = price;
        this.duration = duration;
    }
}
