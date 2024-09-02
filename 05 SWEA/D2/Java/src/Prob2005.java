
/**
* title  : 2005. 파스칼의 삼각형 (D2)
* time   : 95ms
* memory : 18668kb
*/

import java.io.*;
 
public class Prob2005 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());
            int[][] number = new int[N][N];

            for (int i = 0; i < N; i++) {
                number[i][0] = 1;
                number[i][i] = 1;
            }

            for (int i = 2; i < N; i++) {
                for (int j = 1; j < i; j++) {
                    number[i][j] = number[i-1][j-1] + number[i-1][j];
                }
            }

            sb.append("#" + tc).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    sb.append(number[i][j] + " ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
