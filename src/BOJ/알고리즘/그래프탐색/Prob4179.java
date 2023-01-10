package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 불! 576ms 46140KB (java11) 468ms 43900KB (java8)
// 그래프 이론, 그래프 탐색, 너비 우선 탐색

public class Prob4179 {

    private static int R, C, ans; // 행, 열, 탈출시간
    private static char[][] map; // 미로

    private static class pos {
        int x, y;
        boolean isFire; // 불인가?

        public pos(int x, int y, boolean isFire) {
            this.x = x;
            this.y = y;
            this.isFire = isFire;
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 ///////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][];

        Queue<pos> q = new ArrayDeque<>();
        pos temp = null; // 지훈이 위치 임시 저장

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'F') // 불
                    q.offer(new pos(i, j, true));
                else if (map[i][j] == 'J') // 지훈이
                    temp = new pos(i, j, false);
            }
        }

        q.offer(temp); // 지훈이 위치는 제일 마지막에

        // 실행 ///////////////////////////////////////////////////////

        sb.append(escape(q) ? ans : "IMPOSSIBLE");

        System.out.println(sb);
    }

    private static boolean escape(Queue<pos> q) {

        int[] dr = { 0, 0, -1, 1 };
        int[] dc = { -1, 1, 0, 0 };

        while (!q.isEmpty()) {

            ans++;

            for (int i = 0, end = q.size(); i < end; i++) {

                pos now = q.poll();

                for (int d = 0; d < 4; d++) {

                    int nr = now.x + dr[d];
                    int nc = now.y + dc[d];

                    // 지훈이
                    if (!now.isFire) {
                        if (nr == -1 || nc == -1 || nr == R || nc == C)
                            return true;
                        if (map[nr][nc] == '.') { // . 공간으로만 이동 가능
                            q.offer(new pos(nr, nc, false));
                            map[nr][nc] = 'J';
                        }
                    } else { // 불
                        if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '#' || map[nr][nc] == 'F')
                            continue;
                        q.offer(new pos(nr, nc, true));
                        map[nr][nc] = 'F';
                    }

                } // end for
            } // end for
        } // end while

        return false;
    }
}
