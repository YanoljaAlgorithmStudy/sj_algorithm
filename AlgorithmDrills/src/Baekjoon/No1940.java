package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int material = Integer.parseInt(bf.readLine()); // 재료의 수
        int armour = Integer.parseInt(bf.readLine()); // 갑옷이 완성되는 번호의 합

        int[] A = new int[material];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < material; i++) {
            A[i] = Integer.parseInt(st.nextToken()); // 재료들을 배열로 저장
        }

        Arrays.sort(A); // 재료배열 저장
        int count = 0; // 갑옷이 되는 경우의 수
        int left = 0;
        int right = A.length - 1;

        // 투 포인터 이동규칙, material과 armour가 만날 때까지 반복
        while (left < right) {
            if (A[left] + A[right] < armour) {
                left++;
            } else if (A[left] + A[right] > armour) {
                right--;
            } else {
                count++;
                left++;
                right--;
            }
        }
        System.out.println(count);
        bf.close();
    }
}