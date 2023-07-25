package Programmers;

import java.util.Scanner;

public class No42842 {

    public static int[] solution(int brown, int yellow) {
        int totalTiles = brown + yellow;

        // 가로 길이를 3부터 시작해야 노란색 타일을 감쌀 수 있음.
        for (int width = 3; width <= 5000; width++) {
            if (totalTiles % width == 0) {      // 전체 타일 수가 가로 길이로 나누어떨어지면, 세로 길이를 구할 수 있다.
                int height = totalTiles / width;

                // 세로 길이가 가로 길이보다 작거나 같고, 입력한 노란색 격자 수가 맞는 경우에 결과 배열을 구성하여 반환.
                if (height <= width && (width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }
        return new int[]{0, 0}; // 예외처리 0으로 반환하거나 에러 처리
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int brown = sc.nextInt();
        int yellow = sc.nextInt();
        int[] result = solution(brown, yellow);

        System.out.println("카펫의 크기: [" + result[0] + ", " + result[1] + "]");
    }
}