package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon7568 {
    public static void main(String[] args) throws IOException {
        List<Person> data = input();
        System.out.println(logic(data));
    }

    private static List<Person> input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        return new ArrayList<>(){{
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int weight = Integer.parseInt(st.nextToken());
                int height = Integer.parseInt(st.nextToken());
                add(new Person(weight, height));
            }
        }};
    }

    private static StringBuilder logic(List<Person> data) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.size(); i++) {
            int rank = 1;
            for (int j = 0; j < data.size(); j++) {
                if (i == j) continue;
                if (data.get(i).weight < data.get(j).weight && data.get(i).height < data.get(j).height) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }

        return sb;
    }

    static class Person {
        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
