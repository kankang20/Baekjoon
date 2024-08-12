
/**
* title  : 4179. 불! (Gold 3)
* time   : 604ms
* memory : 70408KB
*/

import java.io.*;
import java.util.*;

public class Prob4179 {
    
    static int R, C;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] board = new char[R][C];

        Queue<int[]> ji = new LinkedList<>();
        Queue<int[]> fire = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = temp.charAt(j);

                if (board[i][j] == 'J') {
                    ji.add(new int[] {i, j, 1});
                } else if (board[i][j] == 'F') {
                    fire.add(new int[] {i, j});
                }
            }
        }

        int answer = bfs(board, ji, fire);

        if (answer == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(answer);
        }
    }

    public static int bfs(char[][] board, Queue<int[]> ji, Queue<int[]> fire) {

        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};

        int length = 0;
        while (!ji.isEmpty()) {

            length = fire.size();
            for (int i = 0; i < length; i++) {

                int[] now = fire.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = now[0] + dr[d];
                    int nc = now[1] + dc[d];

                    if (checkBoundary(nr, nc) && (board[nr][nc] == 'J' || board[nr][nc] == '.')) {
                        board[nr][nc] = 'F';
                        fire.add(new int[] {nr, nc});
                    }
                }
            }

            length = ji.size();
            for (int i = 0; i < length; i++) {

                int[] now = ji.poll();

                if (now[0] == 0 || now[1] == 0 || now[0] == (R-1) || now[1] == (C-1)) {
                    return now[2];
                }

                for (int d = 0; d < 4; d++) {
                    int nr = now[0] + dr[d];
                    int nc = now[1] + dc[d];
                    
                    if (checkBoundary(nr, nc) && board[nr][nc] == '.') {
                        board[nr][nc] = 'J';
                        ji.add(new int[] {nr, nc, now[2]+1});
                    }
                }
            }
        }

        return -1;
    }

    public static boolean checkBoundary(int r, int c) {
        if (r < 0 || r >= R || c < 0 || c >= C) return false;
        return true;
    }
}
