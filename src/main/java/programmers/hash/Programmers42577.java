package programmers.hash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/*
전화번호 목록 (https://school.programmers.co.kr/learn/courses/30/lessons/42577)
 */
public class Programmers42577 {
    public static void main(String[] args) {
        System.out.println(solution2(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution2(new String[]{"123", "456", "789"}));
        System.out.println(solution2(new String[]{"12", "123", "1235", "567", "88"}));
    }

    // 효율성 테스트 실패 - 해시 문제에서 해시를 안써서 일어난 실패
    public static boolean solution(String[] phone_book) {

        Arrays.sort(phone_book, Comparator.comparingInt(String::length));

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    // 효율성 테스트 통과
    public static boolean solution2(String[] phone_book) {
        Set<String> set = new HashSet<>();
        Arrays.sort(phone_book, Comparator.comparingInt(String::length).reversed());

        for (String s : phone_book) {
            if (set.contains(s)) {
                return false;
            }

            for (int i = phone_book[phone_book.length - 1].length(); i <= s.length(); i++) {
                set.add(s.substring(0, i));
            }
        }

        return true;
    }
}
