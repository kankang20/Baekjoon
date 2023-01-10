package JUNGOL.Beginner_Coder.도형만들기1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1856 {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int num = 1;

        for (int i = 0; i < n; i++) {

            if (i%2==0) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = (num++);
                } 
            } else {
                for (int j = m-1; j >= 0 ; j--) {
                    map[i][j] = (num++);
                } 
            }
                      
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }
}
