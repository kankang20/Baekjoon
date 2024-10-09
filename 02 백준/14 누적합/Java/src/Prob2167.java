
/**
* title  : 2167. 2차원 배열의 합 (Silver 5)
* time   : ms
* memory : KB
*/

import java.io.*;
import java.util.*;

public class Prob2167 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = new int[N][M];
        
        answer[0][0] = board[0][0];

        for(int i = 1; i < N; i++) {
            answer[i][0] = board[i][0] + answer[i-1][0];
        }

        for(int j = 1; j < M; j++) {
            answer[0][j] = board[0][j] + answer[0][j-1];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                answer[i][j] = board[i][j] + answer[i-1][j] + answer[i][j-1] - answer[i-1][j-1];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken())-1;
            int c1 = Integer.parseInt(st.nextToken())-1;
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken()); 
            sb.append(answer[r2][c2] - answer[r1][c1]).append("\n");
        }

        System.out.println(sb);
    }
}