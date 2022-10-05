package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 내리막길 388ms 35940KB (java11) 328ms 39472KB (java8)
// 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색, 깊이 우선 탐색

public class Prob1520 {

    private static int N, M; // 지도의 가로, 세로
    private static int[][] map, ans; // 지도, 경로 개수

    private static int[] dr = { 0, 0, -1, 1 };
    private static int[] dc = { -1, 1, 0, 0 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 //////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로

        map = new int[N][M];
        ans = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                ans[i][j] = -1;
            }
        }

        // 실행 ///////////////////////////////////////////////////

        sb.append(search(0, 0));

        System.out.println(sb);

    } // main

    private static int search(int x, int y) {

        if (x == N - 1 && y == M - 1)
            return 1;

        if (ans[x][y] > -1)
            return ans[x][y];

        ans[x][y] = 0;

        for (int i = 0; i < 4; i++) {

            int nr = x + dr[i];
            int nc = y + dc[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[x][y] <= map[nr][nc])
                continue;

            ans[x][y] += search(nr, nc);
        }

        return ans[x][y];

    } // search

}
