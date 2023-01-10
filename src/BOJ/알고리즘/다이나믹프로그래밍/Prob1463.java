package BOJ.알고리즘.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1로 만들기 140ms 18200KB (java11) 104ms 15508KB (java8)
// 다이나믹 프로그래밍

public class Prob1463 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] table = new int[N + 1];

        for (int i = 2; i <= N; i++) {

            table[i] = table[i - 1] + 1;
            if (i % 2 == 0)
                table[i] = Math.min(table[i], table[i / 2] + 1);
            if (i % 3 == 0)
                table[i] = Math.min(table[i], table[i / 3] + 1);
        }

        sb.append(table[N]);
        System.out.println(sb);
    }
}
