import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2096 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int postMax1 = Integer.parseInt(st.nextToken());
        int postMax2 = Integer.parseInt(st.nextToken());
        int postMax3 = Integer.parseInt(st.nextToken());
        int postMin1 = postMax1;
        int postMin2 = postMax2;
        int postMin3 = postMax3;

        for (int i = 0; i < n - 1; i++) {
            int temp1, temp2, temp3;
            st = new StringTokenizer(br.readLine(), " ");

            temp1 = Integer.parseInt(st.nextToken());
            temp2 = Integer.parseInt(st.nextToken());
            temp3 = Integer.parseInt(st.nextToken());

            int preMax1 = temp1 + Math.max(postMax1, postMax2);
            int preMax2 = temp2 + max(postMax1, postMax2, postMax3);
            int preMax3 = temp3 + Math.max(postMax2, postMax3);
            int preMin1 = temp1 + Math.min(postMin1, postMin2);
            int preMin2 = temp2 + min(postMin1, postMin2, postMin3);
            int preMin3 = temp3 + Math.min(postMin2, postMin3);

            postMax1 = preMax1;
            postMax2 = preMax2;
            postMax3 = preMax3;
            postMin1 = preMin1;
            postMin2 = preMin2;
            postMin3 = preMin3;
        }

        System.out.println(max(postMax1, postMax2, postMax3) + " " + min(postMin1, postMin2, postMin3));
    }

    private static int max(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        }

        return Math.max(b, c);
    }

    private static int min(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        }

        return Math.min(b, c);
    }
}
