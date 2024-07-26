package 구현;

import java.io.*;
import java.util.*;

public class Prob14889 {

    static int N;
    static int[][] board;

    static int answer;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] selected = new boolean[N];
        answer = Integer.MAX_VALUE;

        divide_team(0, 0, selected);

        System.out.println(answer);
    }

    public static void divide_team(int idx, int count, boolean[] selected) {

        if (count == (N/2)) {
            answer = Math.min(answer, calculate(selected));
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                divide_team(i+1, count+1, selected);
                selected[i] = false;
            }
        }
    }

    public static int calculate(boolean[] selected) {

        int start = 0;
        int link = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (selected[i] && selected[j]) {
                    start += (board[i][j] + board[j][i]);
                } else if (!selected[i] && !selected[j]) {
                    link += (board[i][j] + board[j][i]);
                }
            }
        }

        return Math.abs(start-link);
    }
}
