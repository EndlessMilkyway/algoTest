package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1873 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            char[][] gameField = new char[h][w];

            int row = 0;
            int col = 0;
            char direction = ' ';
            for (int i = 0; i < h; i++) {
                String fieldInput = br.readLine();
                for (int j = 0; j < w; j++) {
                    gameField[i][j] = fieldInput.charAt(j);
                    if (gameField[i][j] == '<' || gameField[i][j] == '>' || gameField[i][j] == '^'
                            || gameField[i][j] == 'v') {
                        row = i;
                        col = j;
                    }

                    switch (gameField[i][j]) {
                        case '^':
                            direction = 'N';
                            break;
                        case 'v':
                            direction = 'S';
                            break;
                        case '<':
                            direction = 'W';
                            break;
                        case '>':
                            direction = 'E';
                            break;
                    }
                }
            }

            int n = Integer.parseInt(br.readLine());

            String commands = br.readLine();

            for (int i = 0; i < n; i++) {
                String a = commands.substring(i, i + 1);
                int idx = 0;
                switch (a) {
                    case "U":
                        direction = 'N';
                        gameField[row][col] = '^';
                        if (row > 0 && gameField[row - 1][col] == '.') {
                            gameField[row - 1][col] = gameField[row][col];
                            gameField[row][col] = '.';
                            row -= 1;
                        }
                        break;
                    case "D":
                        direction = 'S';
                        gameField[row][col] = 'v';
                        if (row < h - 1 && gameField[row + 1][col] == '.') {
                            gameField[row + 1][col] = gameField[row][col];
                            gameField[row][col] = '.';
                            row += 1;
                        }
                        break;
                    case "L":
                        direction = 'W';
                        gameField[row][col] = '<';
                        if (col > 0 && gameField[row][col - 1] == '.') {
                            gameField[row][col - 1] = gameField[row][col];
                            gameField[row][col] = '.';
                            col -= 1;
                        }
                        break;
                    case "R":
                        direction = 'E';
                        gameField[row][col] = '>';
                        if (col < w - 1 && gameField[row][col + 1] == '.') {
                            gameField[row][col + 1] = gameField[row][col];
                            gameField[row][col] = '.';
                            col += 1;
                        }
                        break;
                    case "S":
                        switch (direction) {
                            case 'N':
                                idx = row;
                                while (true) {
                                    if (idx - 1 < 0 || gameField[idx - 1][col] == '#') {
                                        break;
                                    }
                                    if (gameField[idx - 1][col] == '*') {
                                        gameField[idx - 1][col] = '.';
                                        break;
                                    }
                                    idx--;
                                }
                                break;

                            case 'S':
                                idx = row;
                                while (true) {
                                    if (idx + 1 >= h || gameField[idx + 1][col] == '#') {
                                        break;
                                    }
                                    if (gameField[idx + 1][col] == '*') {
                                        gameField[idx + 1][col] = '.';
                                        break;
                                    }
                                    idx++;
                                }
                                break;

                            case 'W':
                                idx = col;
                                while (true) {
                                    if (idx - 1 < 0 || gameField[row][idx - 1] == '#') {
                                        break;
                                    }
                                    if (gameField[row][idx - 1] == '*') {
                                        gameField[row][idx - 1] = '.';
                                        break;
                                    }
                                    idx--;
                                }
                                break;

                            case 'E':
                                idx = col;
                                while (true) {
                                    if (idx + 1 >= w || gameField[row][idx + 1] == '#') {
                                        break;
                                    }
                                    if (gameField[row][idx + 1] == '*') {
                                        gameField[row][idx + 1] = '.';
                                        break;
                                    }
                                    idx++;
                                }
                                break;
                        }
                        break;
                }
            }

            bw.write("#" + testCase + " ");

            for (int k = 0; k < w; k++) {
                bw.write(gameField[0][k]);
            }
            bw.newLine();

            for (int l = 1; l < h; l++) {
                for (int m = 0; m < w; m++) {
                    bw.write(gameField[l][m]);
                }
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }
}
