package baekjoon.trie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon14425Trie {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 트라이 자료구조 생성하기
        Node root = new Node();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            Node now = root;
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (now.next[c - 'a'] == null)
                    now.next[c - 'a'] = new Node();
                now = now.next[c - 'a'];
                if (j == input.length() - 1)
                    now.isEnd = true;
            }
        }

        // 트라이 자료구조 탐색하기
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            Node now = root;
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                // 공백 노드라면 이 문자열을 포함하지 않음
                if (now.next[c - 'a'] == null)
                    break;
                now = now.next[c - 'a'];
                if (j == input.length() - 1 && now.isEnd)
                    cnt++;
            }
        }

        System.out.println(cnt);
    }

    static class Node {
        Node[] next = new Node[26];
        boolean isEnd;
    }
}
