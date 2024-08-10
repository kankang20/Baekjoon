
/**
 * title  : 14888. 연산자 끼워넣기 (Silver 1)
 * time   : 136ms
 * memory : 14388KB
 */

import java.io.*;
import java.util.*;

public class Prob14888 {

    static int N;
    static int[] number, count;

    static int max_answer, min_answer;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        max_answer = Integer.MIN_VALUE;
        min_answer = Integer.MAX_VALUE;

        N = Integer.parseInt(br.readLine());

        number = new int[N];
        count = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            count[i] = Integer.parseInt(st.nextToken());
        }

        search(1, number[0]);

        sb.append(max_answer).append("\n").append(min_answer);
        System.out.println(sb);

    } // end main

    static void search(int idx, int result) {

        if (idx == N) {
            max_answer = Math.max(max_answer, result);
            min_answer = Math.min(min_answer, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (0 < count[i]) {
                count[i] -= 1;
                search(idx+1, calculate_number(i, result, number[idx]));
                count[i] += 1;
            }
        }
    } // end search

    static int calculate_number(int cal, int number1, int number2) {

        if (cal == 0) {
            return number1 + number2;
        } else if (cal == 1) {
            return number1 - number2;
        } else if (cal == 2) {
            return number1 * number2;
        } else {
            if (number1 < 0) {
                return -(Math.abs(number1) / number2);
            } else {
                return number1 / number2;
            }
        }
    } // end calculate_number
}
