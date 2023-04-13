import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BaekJoon13459 {
    private static int[] checkArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        checkArr = new int[100001];
        Arrays.fill(checkArr, -1);

        bfs(n, k);
        bw.write(checkArr[k] + "");
        bw.close();
    }

    private static void bfs(int n, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(n);
        checkArr[n] = 0;

        while (!deque.isEmpty()) {
            int currentNode = deque.poll();

            if (currentNode == k) {
                return;
            }

            if (currentNode * 2 <= 100000 && checkArr[currentNode * 2] == -1) {
                deque.addFirst(currentNode * 2);
                checkArr[currentNode * 2] = checkArr[currentNode];
            }

            if (currentNode > 0 && checkArr[currentNode - 1] == -1) {
                deque.offer(currentNode - 1);
                checkArr[currentNode - 1] = checkArr[currentNode] + 1;
            }

            if (currentNode < 100000 && checkArr[currentNode + 1] == -1) {
                deque.offer(currentNode + 1);
                checkArr[currentNode + 1] = checkArr[currentNode] + 1;
            }
        }
    }
}