package programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
완주하지 못한 선수 (https://school.programmers.co.kr/learn/courses/30/lessons/42576)
 */
public class Programmers42576 {
    public static void main(String[] args) {
        System.out.println(solution3(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution3(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(
                solution3(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }

    public static String solution(String[] participant, String[] completion) {

        String answer = "";

        Map<String, Integer> participantMap = new HashMap<>();
        Map<String, Integer> completionMap = new HashMap<>();

        for (String player : participant) {
            if (participantMap.containsKey(player)) {
                participantMap.replace(player, participantMap.get(player) + 1);
            }

            if (!participantMap.containsKey(player)) {
                participantMap.put(player, 1);
            }
        }

        for (String player : completion) {
            if (completionMap.containsKey(player)) {
                completionMap.replace(player, completionMap.get(player) + 1);
            }

            if (!completionMap.containsKey(player)) {
                completionMap.put(player, 1);
            }
        }

        for (String s : participantMap.keySet()) {
            if (!completionMap.containsKey(s) || !Objects.equals(completionMap.get(s), participantMap.get(s))) {
                answer = s;
            }
        }

        return answer;
    }

    public static String solution2(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            map.compute(participant[i], (k, v) -> v != null ? null : 1);
            if (i < completion.length) {
                map.compute(completion[i], (k, v) -> v != null ? null : 1);
            }
        }

        return map.keySet().iterator().next();
    }

    public static String solution3(String[] participant, String[] completion) {
        Map<String, Long> participantMap = Arrays.stream(participant)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (String name : completion) {
            Long value = participantMap.get(name) - 1L;

            if (value == 0L) {
                participantMap.remove(name);
            } else {
                participantMap.put(name, value);
            }
        }

        return participantMap.keySet().iterator().next();
    }
}
