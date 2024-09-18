
/**
* title  : 4396. 지뢰 찾기 (Silver 4)
* time   : ms
* memory : KB
*/

import java.io.*;
import java.util.*;

public class Prob4396 {

    private static int N;
    private static char[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        char[][] answer = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {

                if (temp[j] == '.') {
                    answer[i][j] = '.';
                    continue;
                }

                // answer[i][j] = count_bomb(i, j);
            }
        }


    }

    public static int count_bomb(int row, int col) {

        int count = 0;

        return count;
    }

}