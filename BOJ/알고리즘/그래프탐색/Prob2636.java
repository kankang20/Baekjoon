package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 치즈 208ms 19364KB (java11) 108ms 12980KB (java8)
// 구현, 그래프 이론, 그래프 탐색, 너비 우선 탐색, 시뮬레이션

public class Prob2636 {

    private static int R, C; // 판의 세로와 가로
    private static int allCheese, previousCheese; // 치즈의 개수, 이전의 치즈 개수
    private static int[][] map; // 판

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 //////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 세로
        C = Integer.parseInt(st.nextToken()); // 가로

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1)
                    allCheese++;
            }
        }

        // 출력 //////////////////////////////////////////////////////////////////

        int hour = 0;

        while (allCheese > 0) {
            previousCheese = allCheese;
            removeCheese();
            hour++;
        }

        sb.append(hour + "\n" + previousCheese);
        System.out.println(sb);
    }

    private static void removeCheese() {

        int[] dr = { 0, 0, -1, 1 };
        int[] dc = { -1, 1, 0, 0 };

        Queue<int[]> q = new ArrayDeque<>();

        boolean[][] selected = new boolean[R][C];

        // 시작
        q.offer(new int[] { 0, 0 });
        selected[0][0] = true;

        while (!q.isEmpty()) {

            for (int i = 0, end = q.size(); i < end; i++) {

                int[] now = q.poll();

                for (int d = 0; d < 4; d++) {

                    int nr = now[0] + dr[d];
                    int nc = now[1] + dc[d];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || selected[nr][nc])
                        continue;

                    // 치즈를 만났다면 그 치즈는 공기에 노출된 것이기 때문에
                    if (map[nr][nc] == 1) {
                        map[nr][nc] = -1;
                        allCheese--;
                    } else if (map[nr][nc] == 0) {
                        q.offer(new int[] { nr, nc });
                        selected[nr][nc] = true;
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1)
                    map[i][j] = 0;
            }
        }
    }
}
