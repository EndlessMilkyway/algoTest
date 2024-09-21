package baekjoon.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon12891_RE {
    static int[] status;
    static int[] criteria;
    static int fulfilledCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 임의 DNA 문자열 길이와 비밀번호로 사용할 부분 문자열 길이 입력
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        // 비밀번호 경우의 수 저장하는 정수형 변수
        int result = 0;

        // 전역변수 초기화 함수 호출
        init();

        // 임의 DNA 문자열 입력
        char[] inputData = br.readLine().toCharArray();

        // 부분 문자열에 포함되어야 할 {'A','C','G','T'}의 최소 개수 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            criteria[i] = Integer.parseInt(st.nextToken());
            if (criteria[i] == 0) {
                fulfilledCnt++;
            }
        }

        // 초기 슬라이딩 윈도우 처리
        for (int i = 0; i < p; i++) {
            add(inputData[i]);
        }

        // 초기 슬라이딩 윈도우가 조건을 만족했을 경우 경우의 수 증가
        if (fulfilledCnt == 4) {
            result++;
        }

        // 슬라이딩 윈도우 처리 부분
        for (int i = p; i < s; i++) {
            int j = i - p;
            add(inputData[i]);
            remove(inputData[j]);
            if (fulfilledCnt == 4) {
                result++;
            }
        }
        br.close();
        System.out.println(result);
    }

    // 전역 변수 초기화 메서드
    private static void init() {
        status = new int[4];
        criteria = new int[4];
        fulfilledCnt = 0;
    }

    // 새로 들어온 문자를 처리하는 함수
    private static void add(char c) {
        switch (c) {
            case 'A':
                addProcess(0);
                break;
            case 'C':
                addProcess(1);
                break;
            case 'G':
                addProcess(2);
                break;
            case 'T':
                addProcess(3);
                break;
        }
    }

    private static void addProcess(int idx) {
        status[idx]++;
        if (status[idx] == criteria[idx]) {
            fulfilledCnt++;
        }
    }

    // 제거되는 문자를 처리하는 함수
    private static void remove(char c) {
        switch (c) {
            case 'A':
                removeProcess(0);
                break;
            case 'C':
                removeProcess(1);
                break;
            case 'G':
                removeProcess(2);
                break;
            case 'T':
                removeProcess(3);
                break;
        }
    }

    private static void removeProcess(int idx) {
        if (status[idx] == criteria[idx]) {
            fulfilledCnt--;
        }
        status[idx]--;
    }
}
