package 그래프탐색;

import java.io.*;
import java.util.*;

public class ProbBFS1926 {

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    static int R, C;
    static int[][] board;
    static boolean[][] selected;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        selected = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int paint_count = 0;
        int paint_area = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 1 && !selected[i][j]) {
                    paint_area = Math.max(paint_area, bfs(i, j));
                    paint_count += 1;
                }
            }
        }

        System.out.println(paint_count);
        System.out.println(paint_area);
    }

    public static int bfs(int sr, int sc) {

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {sr, sc});
        selected[sr][sc] = true;

        int count = 1;
        while (!q.isEmpty()) {

            int[] temp = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = temp[0] + dr[d];
                int nc = temp[1] + dc[d];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C || selected[nr][nc] || board[nr][nc] == 0) {
                    continue;
                }

                q.add(new int[] {nr, nc});
                selected[nr][nc] = true;

                count += 1;
            }
        }

        return count;
    }
}
