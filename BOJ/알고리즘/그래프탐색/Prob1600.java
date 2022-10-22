package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 말이 되고픈 원숭이 616ms 62164KB (java11) 480ms 61432KB (java8)
// 그래프 이론, 그래프 탐색, 너비 우선 탐색

public class Prob1600 {

    private static int K, C, R; // 뛰는 횟수, 판의 가로, 세로 길이
    private static int[][] map; // 판
    private static boolean[][][] visited; // 방문 여부

    private static class monkey {
        int r, c, jump, move;

        public monkey(int r, int c, int jump, int move) {
            this.r = r;
            this.c = c;
            this.jump = jump;
            this.move = move;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 /////////////////////////////////////////////////////////////////////

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C][K + 1]; // 아예 뛰지 않은 경우도 고려

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 실행 /////////////////////////////////////////////////////////////////////

        sb.append(monkeymove());
        System.out.println(sb);
    }

    private static int monkeymove() {

        int[][] dfour = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
        int[][] dhorse = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 }, { 2, 1 } };

        Queue<monkey> q = new ArrayDeque<>();

        // 원숭이 출발
        q.offer(new monkey(0, 0, 0, 0));
        visited[0][0][0] = true;

        int nr = 0, nc = 0; // 현재 원숭이 위치, 이동한 원숭이 위치

        while (!q.isEmpty()) {

            for (int i = 0, end = q.size(); i < end; i++) {

                // 현재 원숭이 위치
                monkey now = q.poll();

                if (now.r == R - 1 && now.c == C - 1)
                    return now.move;

                // 사방탐색
                for (int j = 0; j < 4; j++) {

                    nr = now.r + dfour[j][0];
                    nc = now.c + dfour[j][1];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc][now.jump] || map[nr][nc] == 1)
                        continue;

                    q.offer(new monkey(nr, nc, now.jump, now.move + 1));
                    visited[nr][nc][now.jump] = true;
                }

                if (now.jump == K)
                    continue;

                // 말처럼 점프
                for (int j = 0; j < 8; j++) {

                    nr = now.r + dhorse[j][0];
                    nc = now.c + dhorse[j][1];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc][now.jump + 1] || map[nr][nc] == 1)
                        continue;

                    q.offer(new monkey(nr, nc, now.jump + 1, now.move + 1));
                    visited[nr][nc][now.jump + 1] = true;
                }
            }
        }

        return -1;
    }
}
