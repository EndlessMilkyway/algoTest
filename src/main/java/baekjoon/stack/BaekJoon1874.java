package baekjoon.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon1874 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            int currentVal = arr[i];
            if (currentVal >= num) {
                while (currentVal >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int top = stack.pop();
                if (top > currentVal) {
                    System.out.println("NO");
                    flag = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }

        if (flag) {
            System.out.println(bf.toString());
        }
        br.close();
    }
}
