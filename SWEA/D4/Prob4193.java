package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 수영대회 결승전 (완전탐색 + 구현) 104ms 26856KB

public class Prob4193 {

    private static int N, sr, sc, er, ec, map[][];

    private static class samsung {
        int r, c, time;

        public samsung(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {

            sb = new StringBuilder();

            // 입력 //////////////////////////////////////////////////////////////////////////

            N = Integer.parseInt(br.readLine()); // 바다의 크기

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            sr = Integer.parseInt(st.nextToken());
            sc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            er = Integer.parseInt(st.nextToken());
            ec = Integer.parseInt(st.nextToken());

            // 실행 //////////////////////////////////////////////////////////////////////////

            int ans = swimming(sr, sc);

            sb.append("#" + testcase + " ").append(ans);
            System.out.println(sb);
        }
    }

    private static int swimming(int sr2, int sc2) {

        int[][] dir = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

        Queue<samsung> q = new ArrayDeque<>();

        boolean visited[][] = new boolean[N][N];

        // 시작
        q.offer(new samsung(sr, sc, 1));
        visited[sr][sc] = true;

        while (!q.isEmpty()) {

            for (int i = 0, size = q.size(); i < size; i++) {

                samsung now = q.poll();

                if (now.r == er && now.c == ec)
                    return (now.time - 1);

                for (int d = 0; d < 4; d++) {

                    int nr = now.r + dir[d][0];
                    int nc = now.c + dir[d][1];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 1 || visited[nr][nc])
                        continue;

                    // 소용돌이를 만나면
                    if (map[nr][nc] == 2) {
                        if (now.time % 3 == 0) {
                            q.offer(new samsung(nr, nc, now.time + 1));
                            visited[nr][nc] = true;
                        } else {
                            q.offer(new samsung(now.r, now.c, now.time + 1));
                        }
                    } else {
                        q.offer(new samsung(nr, nc, now.time + 1));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return -1;
    }
}
