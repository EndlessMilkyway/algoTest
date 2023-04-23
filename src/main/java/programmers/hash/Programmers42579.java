package programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Programmers42579 {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
                        new int[]{500, 600, 150, 800, 800})));
        System.out.println(
                Arrays.toString(solution(
                        new String[]{"r&b", "classic", "pop", "classic", "classic", "pop", "r&b", "jazz", "r&b"},
                        new int[]{2500, 500, 600, 150, 800, 2500, 2500, 1000, 2500})));
        System.out.println(
                Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic"},
                        new int[]{600, 600, 600, 600})));
        System.out.println(
                Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic"},
                        new int[]{800, 600, 150, 800})));
    }

    private static int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> totalMap = new HashMap<>();
        Map<Integer, Integer> playtimeMap = new HashMap<>();
        List<String> genresList = new ArrayList<>(Arrays.asList(genres));

        for (int i = 0; i < genres.length; i++) {
            totalMap.put(genres[i], totalMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        for (int j = 0; j < plays.length; j++) {
            playtimeMap.put(j, plays[j]);
        }

        List<Entry<String, Integer>> totalEntries = totalMap.entrySet().stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        List<Entry<Integer, Integer>> playEntries = playtimeMap.entrySet().stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        for (Map.Entry<String, Integer> totalEntry : totalEntries) {
            int count = 0;
            for (Map.Entry<Integer, Integer> playEntry : playEntries) {
                if (genresList.get(playEntry.getKey()).equals(totalEntry.getKey())) {
                    answer.add(playEntry.getKey());
                    count++;
                    if (count == 2) {
                        break;
                    }
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
