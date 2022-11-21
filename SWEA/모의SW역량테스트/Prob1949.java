package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [모의 SW 역량테스트] 등산로 조성 108ms 25012KB

public class Prob1949 {

    private static int N, K, map[][], ans;
    private static boolean visited[][];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            // 입력 //////////////////////////////////////////////////////////////////////////

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];

            int max = Integer.MIN_VALUE;
            ans = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (max < map[i][j])
                        max = map[i][j]; // 가장 높은 봉우리의 높이는?
                }
            }

            // 실행 //////////////////////////////////////////////////////////////////////////

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max) { // 가장 높은 봉우리에서만 출발할 수 있어
                        visited[i][j] = true;
                        mountain(i, j, map[i][j], true, 1);
                        visited[i][j] = false;
                    }
                }
            }

            sb.append("#" + testcase + " " + ans);
            System.out.println(sb);
        }
    } // end main

    private static void mountain(int r, int c, int now, boolean isPossible, int len) {

        if (ans < len)
            ans = len;

        int[][] dir = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

        for (int d = 0; d < 4; d++) {

            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
                continue;

            if (map[nr][nc] < now) { // 현재보다 더 작으면 갈 수 있음
                visited[nr][nc] = true;
                mountain(nr, nc, map[nr][nc], isPossible, len + 1);
                visited[nr][nc] = false;
            } else { // 현재보다 더 높으면
                if (isPossible && map[nr][nc] - K < map[r][c]) {
                    visited[nr][nc] = true;
                    mountain(nr, nc, now - 1, false, len + 1);
                    visited[nr][nc] = false;
                }
            }
        }
    } // end mountain
}
