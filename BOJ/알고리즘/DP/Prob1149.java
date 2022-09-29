package BOJ.알고리즘.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// RGB 거리 136ms 14424KB (java11) 92ms 12340KB (java8)
// 다이나믹 프로그래밍

public class Prob1149 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (i == 0) {
                map[0][0] = Integer.parseInt(st.nextToken());
                map[0][1] = Integer.parseInt(st.nextToken());
                map[0][2] = Integer.parseInt(st.nextToken());
            } else {
                map[i][0] = Math.min(map[i - 1][1], map[i - 1][2]) + Integer.parseInt(st.nextToken());
                map[i][1] = Math.min(map[i - 1][0], map[i - 1][2]) + Integer.parseInt(st.nextToken());
                map[i][2] = Math.min(map[i - 1][0], map[i - 1][1]) + Integer.parseInt(st.nextToken());
            }
        }

        sb.append(Math.min(Math.min(map[N - 1][0], map[N - 1][1]), map[N - 1][2]));
        System.out.println(sb);
    }
}
