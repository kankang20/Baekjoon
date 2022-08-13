package JUNGOL.Beginner_Coder.도형만들기1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob1304 {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[j][i] = (num++); 
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }
}
