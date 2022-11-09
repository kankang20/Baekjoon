package BOJ.알고리즘.그래프탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로탐색 132ms 14496KB (java11) 88ms 12092KB (java8)
// 그래프 이론, 그래프 탐색, 너비 우선 탐색

public class Prob2178 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 ////////////////////////////////////////////////////////////////////

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 실행 ////////////////////////////////////////////////////////////////////

        int ans = game_start(N, M, map);

        sb.append(ans);
        System.out.println(sb);
    }

    private static int game_start(int n, int m, char[][] map) {

        int[][] dir = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } }; // 사방탐색

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] { 0, 0, 1 });
        visited[0][0] = true;

        while (!q.isEmpty()) {

            for (int i = 0, size = q.size(); i < size; i++) {

                int[] now = q.poll();

                for (int d = 0; d < 4; d++) {

                    int nr = now[0] + dir[d][0];
                    int nc = now[1] + dir[d][1];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] || map[nr][nc] == '0')
                        continue;

                    if (nr == n - 1 && nc == m - 1)
                        return now[2] + 1;

                    q.offer(new int[] { nr, nc, now[2] + 1 });
                    visited[nr][nc] = true;
                }
            }
        }

        return 0;

    }
}
