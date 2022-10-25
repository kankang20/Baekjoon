package BOJ.알고리즘.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1, 2, 3 더하기 140ms 15768KB (java11) 76ms 11480KB (java8)
// 다이나믹 프로그래밍

public class Prob9095 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {

            int N = Integer.parseInt(br.readLine());

            if (N == 1)
                sb.append(1 + "\n");
            else if (N == 2)
                sb.append(2 + "\n");
            else if (N == 3)
                sb.append(4 + "\n");
            else {

                int[] table = new int[N + 1];

                table[1] = 1;
                table[2] = 2;
                table[3] = 4;

                for (int i = 4; i <= N; i++) {
                    table[i] = table[i - 1] + table[i - 2] + table[i - 3];
                }

                sb.append(table[N] + "\n");
            }

        }
        System.out.println(sb);
    }
}
