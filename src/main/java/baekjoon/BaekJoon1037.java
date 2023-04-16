package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BaekJoon1037 {
    static int amountOfDivisor, minValue, maxValue, answer;
    static String inputString;
    static int[] divisor;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        maxValue = Integer.MIN_VALUE;
        minValue = Integer.MAX_VALUE;
        amountOfDivisor = Integer.parseInt(br.readLine());
        inputString = br.readLine();
        // Stream을 이용해 String의 숫자들을 int형 배열에 저장하는 방법
        // 자주 사용할 것 같으니 무조건 외워두기!!!!!!
        divisor = Stream.of(inputString.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int j : divisor) {
            if (j < minValue) minValue = j;
            if (j > maxValue) maxValue = j;
        }
        answer = minValue * maxValue;
        System.out.println(answer);
    }
}
