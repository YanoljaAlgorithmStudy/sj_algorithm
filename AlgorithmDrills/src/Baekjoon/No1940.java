package Baekjoon;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1940 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int material = Integer.parseInt(bf.readLine());
        int armour = Integer.parseInt(bf.readLine());

        int[] A = new int[material];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < material; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        int count = 0;
        int left = 0;
        int right = material - 1;

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
