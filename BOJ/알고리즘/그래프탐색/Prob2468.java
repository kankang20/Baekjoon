package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 안전 영역 320ms 40196KB (java11) 288ms 36088KB (java8)
// 그래프 이론, 브루트포스 알고리즘, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

public class Prob2468 {

    private static int N, ans = Integer.MIN_VALUE; // 배열의 크기, 안전한 영역의 최대 개수
    private static int[][] map; // 배열
    private static boolean[][] selected; // 선택 여부

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 /////////////////////////////////////////////////////////////

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        int max_height = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (max_height < map[i][j])
                    max_height = map[i][j];
            }
        }

        // 실행 //////////////////////////////////////////////////////////////

        for (int i = 0; i <= max_height; i++) { // 물이 잠기는 모든 경우 탐방

            selected = new boolean[N][N]; // 초기화
            rainmark(i); // 물이 잠긴 지역 표시 - true / false

            int count = 0; // 안전 지역 개수

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!selected[r][c]) {
                        safemark(r, c);
                        count++;
                    }
                }
            }
            ans = Math.max(ans, count);
        }

        sb.append(ans);
        System.out.println(sb);
    } // end main

    private static void rainmark(int standard) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] <= standard)
                    selected[i][j] = true;
            }
        }

    } // end rainmark

    private static void safemark(int startr, int startc) {

        int[] dr = { 0, 0, -1, 1 };
        int[] dc = { -1, 1, 0, 0 };

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] { startr, startc });
        selected[startr][startc] = true;

        while (!q.isEmpty()) {

            for (int i = 0, end = q.size(); i < end; i++) {

                int[] now = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = now[0] + dr[d];
                    int nc = now[1] + dc[d];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N || selected[nr][nc])
                        continue;

                    q.offer(new int[] { nr, nc });
                    selected[nr][nc] = true;
                }
            }
        }

    } // end safemark
}
