package 그래프탐색;

import java.io.*;
import java.util.*;

public class ProbDFS1926 {

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    static int R, C;
    static int[][] board;
    static boolean[][] selected;

    static int count;
    static int paint_area;
    
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
        paint_area = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 1 && !selected[i][j]) {
                    paint_count += 1;
                    count = 0;
                    dfs(i, j);
                    paint_area = Math.max(count, paint_area);
                }
            }
        }

        System.out.println(paint_count);
        System.out.println(paint_area);
    }

    public static void dfs(int sr, int sc) {

        selected[sr][sc] = true;
        count += 1;

        for (int d = 0; d < 4; d++) {
            int nr = sr + dr[d];
            int nc = sc + dc[d];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C || selected[nr][nc] || board[nr][nc] == 0) {
                continue;
            }

            dfs(nr, nc);
        }
    }
}
