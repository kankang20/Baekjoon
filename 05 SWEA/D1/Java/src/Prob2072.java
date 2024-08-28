
/**
* title  : 2072. 홀수만 더하기 (D1)
* time   : 102ms
* memory : 18960MB
*/

import java.io.*;
import java.util.*;
 
public class Prob2072 {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            int answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());
                
                if (num % 2 == 1) {
                    answer += num;
                }
            }

            sb.append("#" + t).append(" " + answer).append("\n");
        }

        System.out.println(sb);
    }
}
