
/**
* title  : 2068. 최대수 구하기 (D1)
* time   : 103ms
* memory : 18612MB
*/

import java.io.*;
import java.util.*;
 
public class Prob2068 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            int answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                answer = Math.max(answer, Integer.parseInt(st.nextToken()));
            }

            sb.append("#" + t).append(" " + answer).append("\n");
        }

        System.out.println(sb);
    }
}
