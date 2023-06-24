package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1926 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            if (i < 10) {
                if (i % 3 == 0) {
                    sb.append("-").append(" ");
                } else {
                    sb.append(i).append(" ");
                }
            } else if (i < 100) {
                int tensDigit = i / 10;
                int unitDigit = i - (tensDigit * 10);

                if (tensDigit % 3 == 0) {
                    if (unitDigit % 3 == 0 && unitDigit != 0) {
                        sb.append("--").append(" ");
                    } else {
                        sb.append("-").append(" ");
                    }
                } else {
                    if (unitDigit % 3 == 0 && unitDigit != 0) {
                        sb.append("-").append(" ");
                    } else {
                        sb.append(i).append(" ");
                    }
                }

            } else {
                if (i == 1000) {
                    sb.append(1000);
                    break;
                }
                int hundredsDigit = i / 100;
                int tensDigit = (i - (hundredsDigit * 100)) / 10;
                int unitDigit = i - (hundredsDigit * 100 + tensDigit * 10);

                if (hundredsDigit % 3 == 0) {
                    if (tensDigit % 3 == 0 && tensDigit != 0) {
                        if (unitDigit % 3 == 0 && unitDigit != 0) {
                            sb.append("---").append(" ");
                        } else {
                            sb.append("--").append(" ");
                        }
                    } else {
                        if (unitDigit % 3 == 0 && unitDigit != 0) {
                            sb.append("--").append(" ");
                        } else {
                            sb.append("-").append(" ");
                        }
                    }
                } else {
                    if (tensDigit % 3 == 0 && tensDigit != 0) {
                        if (unitDigit % 3 == 0 && unitDigit != 0) {
                            sb.append("--").append(" ");
                        } else {
                            sb.append("-").append(" ");
                        }
                    } else {
                        if (unitDigit % 3 == 0 && unitDigit != 0) {
                            sb.append("-").append(" ");
                        } else {
                            sb.append(i).append(" ");
                        }
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
