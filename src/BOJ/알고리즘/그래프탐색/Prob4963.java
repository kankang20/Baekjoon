package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 섬의 개수 176ms 15876KB
// 그래프 이론, 그래프 탐색, 너비우선탐색, 깊이우선탐색

public class Prob4963 {

    static int w, h, count;
    static boolean[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;

        while (true) {
            sb = new StringBuilder();

            // 기본 입력
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 너비 = 열
            h = Integer.parseInt(st.nextToken()); // 높이 = 행

            // while을 무한루프가 아니라 w가 0, h가 0이 아닐때만 실행하게 해도 실행시간 동일 (마지막에 입력받음)

            if (w == 0 && h == 0)
                break;

            map = new boolean[h][w];
            count = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++)
                    map[i][j] = (Integer.parseInt(st.nextToken()) == 1 ? true : false);
            }

            // 섬의 개수 탐방
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j]) {
                        island(i, j);
                        count++;
                    }
                }
            }

            sb.append(count);
            System.out.println(sb);
        }
    }

    private static void island(int i, int j) {

        int[] dr = { 0, 0, -1, 1, 1, 1, -1, -1 };
        int[] dc = { -1, 1, 0, 0, 1, -1, 1, -1 };

        Queue<Integer[]> queue = new ArrayDeque<>();

        // 시작점
        queue.offer(new Integer[] { i, j });
        map[i][j] = false;

        while (!queue.isEmpty()) {

            Integer[] tmp = queue.poll();

            for (int k = 0; k < 8; k++) {
                int nr = tmp[0] + dr[k];
                int nc = tmp[1] + dc[k];

                if (nr < 0 || nc < 0 || nr >= h || nc >= w || !map[nr][nc])
                    continue;

                queue.offer(new Integer[] { nr, nc });
                map[nr][nc] = false;
            }
        }
    }

}
