import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Random {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int amount = 1;
        char[] arr = new char[]{'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        while (true) {
            System.out.println("현재 난수 생성 개수 : " + amount);
            System.out.println("1. 난수 생성");
            System.out.println("2. 개수 설정");
            System.out.println("0. 종료");
            int command = 999;
            try {
                int commandInput = Integer.parseInt(br.readLine());
                if (!(commandInput == 1 || commandInput == 2 || commandInput == 0)) {
                    throw new InputException("잘못된 명령어입니다! 다시 입력해주세요");
                } else {
                    command = commandInput;
                }
            } catch (InputException e) {
                System.out.println("에러 메시지: " + e.getMessage());
                continue;
            }

            if (command == 0) {
                break;
            } else if (command == 2) {
                System.out.print("생성할 난수 개수를 입력하시오 (기본값은 1, 최대 14) : ");
                try {
                    int amountInput = Integer.parseInt(br.readLine());
                    if (!(amountInput <= 14 && amountInput >= 1)) {
                        throw new InputException("입력이 올바르지 않습니다!");
                    } else {
                        amount = amountInput;
                    }
                } catch (InputException e) {
                    System.out.println("에러 메시지: " + e.getMessage());
                }
            } else {
                for (int i = amount; i >= 1; i--) {
                    System.out.print(arr[arr.length - i] + ": " + new java.util.Random().nextInt(10) + " ");
                }
                System.out.println();
            }
        }
    }

    static class InputException extends Exception {
        InputException(String message) {
            super(message);
        }
    }
}
