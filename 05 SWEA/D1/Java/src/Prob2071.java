
/**
* title  : 2071. 평균값 구하기 (D1)
* time   : 126ms
* memory : 19812kb
*/

import java.io.*;
import java.util.*;
 
public class Prob2071 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            int answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                answer += Integer.parseInt(st.nextToken());
            }

            sb.append("#" + t).append(" " + String.format("%.0f", answer/10.0)).append("\n");
        }

        System.out.println(sb);
    }
}
