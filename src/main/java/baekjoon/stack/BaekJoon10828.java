package baekjoon.stack;

import java.io.*;
import java.util.*;

public class BaekJoon10828 {
    static int N, pushNum;
    static String command;

    // ArrayList는 크기가 고정적인 배열과 달리 크기가 가변적이여서 자료구조 구현시에는 거의 ArrayList를 사용해야 할 것 같다.
    static ArrayList<Integer> stack = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            command = br.readLine();
            if (command.contains("push")) {
                pushNum = Integer.parseInt(command.substring(5, command.length()));
                stack.add(pushNum);
            } else if (Objects.equals(command, "pop")) {
                if (stack.size() > 0) {
                    bw.write(String.valueOf(stack.get(stack.size() - 1))+"\n");
                    bw.flush();
                    stack.remove(stack.size() - 1);
                } else {
                    bw.write(-1+"\n");
                    bw.flush();
                }
            } else if (Objects.equals(command, "top")) {
                if (stack.size() > 0) {
                    bw.write(String.valueOf(stack.get(stack.size() - 1))+"\n");
                    bw.flush();
                } else {
                    bw.write(-1+"\n");
                    bw.flush();
                }
            } else if (Objects.equals(command, "size")) {
                bw.write(stack.size()+"\n");
                bw.flush();
            } else if (Objects.equals(command, "empty")) {
                if (stack.size() == 0) {
                    bw.write(1+"\n");
                    bw.flush();
                } else {
                    bw.write(0+"\n");
                    bw.flush();
                }
            }
        }
        bw.close();
    }
}
