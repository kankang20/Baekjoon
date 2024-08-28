
/**
* title  : 1933. 간단한 N의 약수 (D1)
* time   : 104ms
* memory : 18900kb
*/

import java.io.*;
 
public class Prob1933 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}
