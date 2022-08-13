package JUNGOL.Beginner_Coder.도형만들기1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob1307 {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int num = 65;

        char[][] map = new char[n][n];

        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (num > 90) num = 65;
                map[j][i] = (char) (num++);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
