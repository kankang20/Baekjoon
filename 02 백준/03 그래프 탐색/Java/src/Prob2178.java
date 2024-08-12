
/**
* title  : 2178. 미로 탐색 (Silver 1)
* time   : 120ms
* memory : 14696KB
*/

import java.io.*;
import java.util.*;

public class Prob2178 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] board = new char[R][C];
        for(int i = 0; i < R; i++) {
            String temp = br.readLine();
            for(int j = 0; j < C; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        System.out.println(bfs(R, C, board));
    }

    public static int bfs(int R, int C, char[][] board) {

        Queue<int[]> q = new LinkedList<>();
        boolean[][] selected = new boolean[R][C];

        q.add(new int[] {0, 0, 1});
        selected[0][0] = true;

        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            
            int[] cur = q.poll();

            if (cur[0] == (R-1) && cur[1] == (C-1)) {
                return cur[2];
            }

            for (int d = 0; d < 4; d++) {

                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (board[nr][nc] == '0' || selected[nr][nc]) continue;

                q.add(new int[] {nr, nc, cur[2]+1});
                selected[nr][nc] = true;
            }
        }

        return -1;
    }
}
