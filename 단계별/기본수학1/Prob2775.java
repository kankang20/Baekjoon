package 단계별.기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2775 {
    public static void main(String[] args) throws IOException {
       
        // OPTION 1 : 136ms 14552KB
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] count = new int[15][15];

        for (int i = 0; i < 15; i++) {
            count[i][1] = 1;
            count[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                count[i][j] = count[i-1][j] + count[i][j-1];
            }
        }
        
        int T = Integer.parseInt(br.readLine());
         
        for (int i = 0; i < T; i++) {

            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            if (k==0) {
                sb.append(n + "\n");
            }
        }
    
        System.out.print(sb);
        br.close();    
    }
}
