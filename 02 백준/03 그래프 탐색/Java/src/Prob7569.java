
/**
* title  : 7569. 토마토 (Gold 5)
* time   : 656ms
* memory : 126032KB
*/

import java.io.*;
import java.util.*;

public class Prob7569 {
    
    static int H, R, C;
    static int[][][] board;

    static int[] dh = {1, -1, 0, 0, 0, 0};
    static int[] dr = {0, 0, 0, 0, -1, 1};
    static int[] dc = {0, 0, 1, -1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H][R][C];
        Queue<int[]> q = new LinkedList<>();

        int tomato = 0;
        for (int h = 0; h < H; h++) {
            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < C; c++) {
                    board[h][r][c] = Integer.parseInt(st.nextToken());

                    if (board[h][r][c] == 1) {
                        q.add(new int[] {h, r, c});
                    } else if (board[h][r][c] == 0) {
                        tomato++;
                    }
                }
            }
        }

        System.out.println(bfs(q, tomato));
    }

    public static int bfs(Queue<int[]> q, int tomato) {

        int answer = -1;
        while (!q.isEmpty()) {

            answer++;

            int length = q.size();
            for (int i = 0; i < length; i++) {

                int[] now = q.poll();

                for (int d = 0; d < 6; d++) {
                    int nh = now[0] + dh[d];
                    int nr = now[1] + dr[d];
                    int nc = now[2] + dc[d];

                    if (nh < 0 || nh >= H || nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (board[nh][nr][nc] == 0) {
                        q.add(new int[] {nh, nr, nc});
                        board[nh][nr][nc] = 1;
                        tomato--;
                    }
                }
            }
        }
        return (tomato > 0) ? -1 : answer;
    }
}
