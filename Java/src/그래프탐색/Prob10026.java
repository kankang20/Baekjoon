package 그래프탐색;

import java.util.*;
import java.io.*;

public class ProbBFS10026 {

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    static int N;
    static boolean[][] selected;
    static boolean[][] nselected;
    
    public static void main (String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][N];
        char[][] nboard = new char[N][N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                char tt = temp.charAt(j);
                board[i][j] = tt;
                nboard[i][j] = (tt == 'G') ? 'R' : tt;
            }
        }

        selected = new boolean[N][N];
        nselected = new boolean[N][N];

        int answer = 0;
        int nanswer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!selected[i][j]) {
                    selected[i][j] = true;
                    bfs(board, i, j, true);
                    answer++;
                }
                if (!nselected[i][j]) {
                    nselected[i][j] = true;
                    bfs(nboard, i, j, false);
                    nanswer++;
                }
            }
        }

        System.out.println(answer + " " + nanswer);
    }

    public static void bfs(char[][] board, int r, int c, boolean flag) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});

        char word = board[r][c];
        while (!q.isEmpty()) {

            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if ((flag && selected[nr][nc]) || (!flag && nselected[nr][nc])) continue;

                if (board[nr][nc] == word) {

                    if (flag) {
                        selected[nr][nc] = true;
                    } else {
                        nselected[nr][nc] = true;
                    }

                    q.add(new int[] {nr, nc});
                }
            }
        }
    }
}