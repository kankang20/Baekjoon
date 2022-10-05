package JUNGOL.Intermediate_Coder.동적계획법1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배낭채우기2 171ms 45692KB

public class Prob1278 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] weights = new int[N + 1]; // 보석의 무게들
        int[] values = new int[N + 1]; // 보석의 값어치

        int[][] table = new int[N + 1][W + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken()); // 보석의 무게
            values[i] = Integer.parseInt(st.nextToken()); // 보석의 값어치
        }

        for (int item = 1; item <= N; item++) {
            int weight = weights[item];
            int value = values[item];

            for (int w = 0; w <= W; w++) {

                if (weight <= w) // 만약 아이템의 무게가 배낭보다 작다면 -> 아이템 넣을 수 있음
                    table[item][w] = Math.max(table[item - 1][w], table[item - 1][w - weight] + value);
                else // 만약 아이템의 무게가 배낭보다 크다면 -> 아이템 넣을 수 없음
                    table[item][w] = table[item - 1][w];
            }
        }

        sb.append(table[N][W]);
        System.out.println(sb);
    }
}
