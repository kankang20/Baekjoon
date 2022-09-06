package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 점프왕 쩰리 (Large) 148ms 14608KB
// 그래프 이론, 그래프 탐색, 너비우선탐색, 깊이우선탐색

public class Prob16174 {

    static int N; // 게임 구역의 크기
    static int[][] map; // 게임판
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 기본 입력
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 실행

        if (search())
            sb.append("HaruHaru");
        else
            sb.append("Hing");

        System.out.println(sb);
    }

    private static boolean search() {

        int[] dr = { 0, 1 };
        int[] dc = { 1, 0 };

        Queue<Integer[]> q = new ArrayDeque<>();

        q.offer(new Integer[] { 0, 0 });
        visited[0][0] = true;

        while (!q.isEmpty()) {

            Integer[] cur = q.poll();
            int size = map[cur[0]][cur[1]];

            for (int i = 0; i < 2; i++) {
                int nr = cur[0] + dr[i] * size;
                int nc = cur[1] + dc[i] * size;

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
                    continue;

                if (nr == N - 1 && nc == N - 1)
                    return true;

                q.offer(new Integer[] { nr, nc });
                visited[nr][nc] = true;
            }
        }

        return false;
    }
}
