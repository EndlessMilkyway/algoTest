package baekjoon.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int testAmount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testAmount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Item> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                queue.offer(new Item(j, Integer.parseInt(st.nextToken())));
            }
            sb.append(logic(m, queue)).append("\n");
        }
        System.out.println(sb);
    }

    private static int logic(int m, Queue<Item> queue) {
        int cnt = 0;
        if (queue.size() == 1) return 1;
        while (true) {
            Item item = queue.poll();
            boolean flag = true;
            for (Item i : queue) {
                if (item.priority < i.priority) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                queue.offer(item);
                continue;
            }
            cnt++;
            if (item.idx == m) break;
        }
        return cnt;
    }

    static class Item {
        int idx;
        int priority;

        public Item(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

}
