package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon10814 {
    private static List<Member> list;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();
        input();
        list.sort((o1, o2) -> {
            if (o1.age > o2.age) {
                return 1;
            } else if (o1.age == o2.age) {
                if (o1.registerTime > o2.registerTime) {
                    return 1;
                } else {
                    return 0;
                }
            }
            return -1;
        });

        for (Member m : list) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }

        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken(), i));
        }
    }

    static class Member {
        int age;
        String name;
        int registerTime;

        public Member(int age, String name, int registerTime) {
            this.age = age;
            this.name = name;
            this.registerTime = registerTime;
        }
    }
}
