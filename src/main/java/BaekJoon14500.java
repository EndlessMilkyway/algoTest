import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon14500 {

    private static int n, m, result;
    private static int[][] field;
    private static boolean[][] visited;

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {-1, 1, 0, 0};

    private static final int[][] ex = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
    private static final int[][] ey = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // Init visited array
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }

        // Generate game field
        field = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[] ints : field) {
            System.out.println(Arrays.toString(ints));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, field[i][j], 1);
                visited[i][j] = false;
                checkout_shape(i, j);
            }
        }

        System.out.println(result);

    }


    // Fina a maximum tetromino sum
    public static void dfs(int x, int y, int sum, int length) {

        if (length == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;

                dfs(nx, ny, sum + field[nx][ny], length + 1);

                visited[nx][ny] = false;
            }
        }
    }

    public static void checkout_shape(int x, int y) {

        for (int i = 0; i < 4; i++) {

            boolean outRangeFlag = false;
            int sum = 0;

            for (int j = 0; j < 4; j++) {
                int nx = x + ex[i][j];
                int ny = y + ey[i][j];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    outRangeFlag = true;
                    break;
                } else {
                    sum += field[nx][ny];
                }
            }
            if (!outRangeFlag) {
                result = Math.max(result, sum);
            }
        }
    }

}
