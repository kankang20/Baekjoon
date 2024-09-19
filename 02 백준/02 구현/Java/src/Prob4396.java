
/**
* title  : 4396. 지뢰 찾기 (Silver 4)
* time   : ms
* memory : KB
*/

import java.io.*;

public class Prob4396 {

    private static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, 
                                    {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    private static int N;
    private static char[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        int[][] answer = new int[N][N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = temp.charAt(j);
                answer[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (temp[j] == 'x') {
                    answer[i][j] = count_bomb(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (0 <= answer[i][j]) {
                    sb.append(answer[i][j]);
                } else {
                    sb.append('.');
                }
            }
            sb.append("\n"); 
        }

        System.out.println(sb);
    }

    public static int count_bomb(int row, int col) {

        int count = 0;
        for (int[] d : dir) {

            int nr = row + d[0];
            int nc = col + d[1];

            if (0 <= nr && nr < N && 0 <= nc && nc < N && board[nr][nc] == '*') {
                count++;
            }
        }

        return count;
    }
}