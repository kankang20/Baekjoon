
/**
 * title  : 2578. 빙고 (Silver 4)
 * time   : 100ms
 * memory : 14112KB
 */

import java.io.*;
import java.util.*;

public class Prob2578 {

    private static int SIZE = 5;
    private static int[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[SIZE][SIZE];

        StringTokenizer st;
        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 1;

        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {

                int number = Integer.parseInt(st.nextToken());
                find_number(number);    

                if (3 <= search_bingo()) break;

                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void find_number(int number) {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == number) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static int search_bingo() {

        int count = 0;

        int di1 = 0;
        int di2 = 0;

        for (int i = 0; i < SIZE; i++) {
            int row = 0;
            int col = 0;

            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) row++;
                if (board[j][i] == 0) col++;
            }

            if (row == SIZE) count++;
            if (col == SIZE) count++;

            if (board[i][i] == 0) di1++;
            if (board[i][SIZE-1-i] == 0) di2++;
        }

        if (di1 == SIZE) count++;
        if (di2 == SIZE) count++;

        return count;
    }
}