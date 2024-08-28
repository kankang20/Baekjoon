
/**
* title  : 2019. 더블더블 (D1)
* time   : 96ms
* memory : 16884kb
*/

import java.io.*;
 
public class Prob2019 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int answer = 1;

        sb.append(answer).append(" ");
        for (int i = 1; i <= N; i++) {
            answer *= 2;
            sb.append(answer).append(" ");
        }

        System.out.println(sb);
    }
}
