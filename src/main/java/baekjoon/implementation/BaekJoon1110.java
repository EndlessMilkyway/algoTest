package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class BaekJoon1110 {
    static int temp, count;
    static String inputString;

    public static void main(String[] args) throws IOException {
        int[] N = new int[2], temp2 = new int[2], temp3 = new int[2];
        count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputString = br.readLine();

        if (inputString.length() < 2 ) {
            N[1] = Integer.parseInt(inputString);
            temp2[1] = Integer.parseInt(inputString);
        } else {
            N = Stream.of(inputString.split("")).mapToInt(Integer::parseInt).toArray();
            temp2 = Stream.of(inputString.split("")).mapToInt(Integer::parseInt).toArray();
        }

        do {
            temp = temp2[0] + temp2[1];
            if (temp < 10) {
                temp3[0] = 0;
                temp3[1] = temp;
            } else {
                temp3 = Stream.of(String.valueOf(temp).split("")).mapToInt(Integer::parseInt).toArray();
            }
            temp2[0] = temp2[1];
            temp2[1] = temp3[1];
            count += 1;
        }
        while (!Arrays.equals(temp2, N));

        System.out.println(count);
    }
}
