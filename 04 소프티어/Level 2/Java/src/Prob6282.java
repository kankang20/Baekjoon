
/**
* title  : 6282. 장애물 인식 프로그램 (Level 2)
* time   : 84ms
* memory : 10.97MB
*/

import java.io.*;
import java.util.*;

public class Prob6282 {
    
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] temp = (br.readLine()).split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(temp[j]);
            }
        }

        List<Integer> answer_all = new ArrayList<>();
        int answer_count = 0;

        boolean[][] selected = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!selected[i][j] && board[i][j] > 0) {
                    answer_count += 1;
                    answer_all.add(bfs(N, board, selected, i, j));
                }
            }
        }

        Collections.sort(answer_all);

        System.out.println(answer_count);
        for (Integer ans : answer_all) {
            System.out.println(ans);
        }
        
    }

    public static int bfs(int N, int[][] board, boolean[][] selected, int r, int c) {

        int count = 0;
        
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {r, c});
        selected[r][c] = true;

        while (!q.isEmpty()) {

            int[] temp = q.poll();
            count += 1;

            for (int d = 0; d < 4; d++) {
                int nr = temp[0] + dr[d];
                int nc = temp[1] + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || selected[nr][nc]) {
                    continue;
                }

                if (board[nr][nc] > 0) {
                    q.add(new int[] {nr, nc});
                    selected[nr][nc] = true;
                }
            }
        }

        return count;
    }
}
