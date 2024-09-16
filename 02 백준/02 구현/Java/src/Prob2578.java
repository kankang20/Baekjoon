
/**
 * title  : 20546. 기적의 매매법 (Silver 5)
 * time   : 100ms
 * memory : 14240KB
 */

import java.io.*;
import java.util.*;

public class Prob2578 {

    private static int[][] board;
    private static boolean[][] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[5][5];
        check = new boolean[5][5];

        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int answer = 1;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {

                int number = Integer.parseInt(st.nextToken());
                int[] pos = find_number(number);

                


            }
        }

        System.out.println(answer);
    }

    public static int[] find_number(int number) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == number) {
                    check[i][j] = true;
                    return new int[] {i, j};
                }
            }
        }

        return null;
    }
}