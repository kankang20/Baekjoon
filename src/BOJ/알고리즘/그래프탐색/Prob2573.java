package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 빙산 552ms 56220KB (java11) 488ms 54732KB (java8)
// 구현, 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

public class Prob2573 {

    private static int R, C, map[][], melting[][], check;
    private static boolean[][] visited;

    private static int[][] dir = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 //////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 실행 //////////////////////////////////////////////////////////

        int count = 0, time = 0;

        visited = new boolean[R][C];
        melting = new int[R][C];

        while (true) {

            init();

            count = 0;
            check = 0;

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        melting(i, j);
                        count++;
                    }
                }
            }

            if (check == 0) {
                sb.append(0);
                break;
            }

            if (count > 1) {
                sb.append(time);
                break;
            }

            time++;

        }

        System.out.println(sb);
    }

    private static void init() {

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visited[i][j] = false;
                melting[i][j] = 0;
            }
        }
    }

    private static void melting(int r, int c) {

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] { r, c });
        visited[r][c] = true;

        while (!q.isEmpty()) {

            for (int i = 0, size = q.size(); i < size; i++) {

                int[] now = q.poll();

                for (int j = 0; j < 4; j++) {

                    int nr = now[0] + dir[j][0];
                    int nc = now[1] + dir[j][1];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C)
                        continue;

                    if (map[nr][nc] == 0)
                        melting[now[0]][now[1]]++;

                    if (!visited[nr][nc] && map[nr][nc] > 0) {
                        q.offer(new int[] { nr, nc });
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (melting[i][j] > 0) {
                    map[i][j] -= melting[i][j];
                    check++;
                    if (map[i][j] < 0)
                        map[i][j] = 0;
                }
            }
        }

    } // end melted

}
