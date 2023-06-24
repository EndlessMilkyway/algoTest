package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class SWEA1204 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map;

        for (int testCase = 1; testCase <= T; testCase++) {
            int uselessInput = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            map = new HashMap<>();

            while (st.hasMoreTokens()) {
                int input = Integer.parseInt(st.nextToken());
                if (!map.containsKey(input)) {
                    map.put(input, 1);
                } else {
                    map.put(input, map.get(input) + 1);
                }
            }

            List<Entry<Integer, Integer>> list = map.entrySet().stream().sorted(Entry.comparingByValue())
                    .collect(Collectors.toList());

            sb.append("#").append(testCase).append(" ").append(list.get(list.size() - 1).getKey()).append("\n");
        }
        System.out.println(sb);
    }
}
