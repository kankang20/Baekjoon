package BOJ.알고리즘2.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Lv 3. 바이러스

public class Prob2606 {

    private static int N, number, count;
    private static boolean[][] map;
    private static boolean[] computer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());        // 컴퓨터의 수
        number = Integer.parseInt(br.readLine());    // 연결되어 있는 컴퓨터 쌍의 수

        computer = new boolean[N];
        map = new boolean[N][N];

        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;

            map[start][end] = true;
            map[end][start] = true;
        }

        virus(0, 0);

        sb.append(count-1);
        System.out.println(sb);

    } // end main

    private static void virus(int cnt, int com) {

        for (int i = 0; i < N; i++) {
            if(!computer[i] && map[com][i]) {
                count++;
                computer[i] = true;
                virus(cnt+1, i);
            }
        }
    } // end virus
}
